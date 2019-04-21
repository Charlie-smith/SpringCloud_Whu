package com.whu.user.service.impl;

import com.whu.user.entity.User;
import com.whu.user.enums.UserEnum;
import com.whu.user.exception.UserException;
import com.whu.user.repository.UserRepository;
import com.whu.user.service.UserService;
import com.whu.user.util.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;

    @Override
    public String sendCode(String userEmail) {
        String code = KeyUtil.RandomCode();
        String subject = "【WHU】用户注册验证码";
        String content = "你的验证码为:"+code;
        try{
            mailService.sendSimpleMail(userEmail,subject,content);
        }catch (Exception e){
            throw new UserException(UserEnum.MAIL_SEND_FAIL);
        }
        return code;
    }

    @Override
    public User userAdd(User user) {
        if(userRepository.findByUserEmail(user.getUserEmail())!=null)
            throw new UserException(UserEnum.EMAIL_REPEAT);
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return userRepository.findByUserEmailAndPassword(email,password);
    }

    @Override
    public User findUserById(String user_id) {
        return userRepository.findById(user_id).orElse(null);
    }

    @Override
    public User updateUserInfo(User user) {
        return userRepository.save(user);
    }
}
