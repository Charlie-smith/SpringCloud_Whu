package com.whu.user.service;

import com.whu.user.entity.User;

public interface UserService {

    String sendCode(String userEmail);

    User userAdd(User user);

    User findUserByEmailAndPassword(String email,String password);

    User findUserById(String user_id);

    User updateUserInfo(User user);

}
