package com.whu.user.controller;

import com.google.gson.Gson;
import com.whu.user.entity.User;
import com.whu.user.enums.UserEnum;
import com.whu.user.exception.UserException;
import com.whu.user.service.impl.UserServiceImpl;
import com.whu.user.vo.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private Gson gson;



    @RequestMapping("/send/verification")
    public ResponseInfo verification(@RequestBody String data){
        String userEmail = gson.fromJson(data,Map.class).get("userEmail").toString();
        String code = userService.sendCode(userEmail);
        return new ResponseInfo(new HashMap<String,String>()
        {{
            put("code",code);
        }});
    }



    @RequestMapping("/user_logout")
    public void logout(HttpSession httpSession){
        httpSession.removeAttribute("userId");
    }

    //用户更新信息，代码合格测试通过
    @RequestMapping("/user_update")
    public ResponseInfo update(@RequestBody String data){

        User user = gson.fromJson(data,User.class);
        if(userService.findUserById(user.getUserId())==null)
            throw new UserException(UserEnum.USER_NOT_EXIST);
        userService.updateUserInfo(user);
        return new ResponseInfo(user);
    }


    //用户注册，代码合格测试通过
    @RequestMapping("/user_register")
    public ResponseInfo register(@RequestBody String data,HttpSession httpSession){

        User user = gson.fromJson(data,User.class);
        userService.userAdd(user);
        String userId = user.getUserId();
        httpSession.setAttribute("user_id",userId);
        return new ResponseInfo(new HashMap<String,String>()
        {{
            put("userId",userId);
        }});
    }


    //用户登陆，代码合格测试通过
    @RequestMapping("/user_login")
    public ResponseInfo login(@RequestBody String data, HttpSession httpSession){

        //接收请求参数并进行查询
        User requestInfo = gson.fromJson(data,User.class);
        User user = userService.findUserByEmailAndPassword(
                requestInfo.getUserEmail(),
                requestInfo.getPassword()
        );
        if(user==null)
            throw new UserException(UserEnum.LOGIN_FAIL);

        //登陆成功进行session存储
        String userId = user.getUserId();
        httpSession.setAttribute("userId",userId);
        return new ResponseInfo(new HashMap<String,String>()
        {{
            put("userId",userId);
        }});
    }


    //通过用户id查询用户信息 代码合格验证通过
    @RequestMapping("/user_information")
    public ResponseInfo information(@RequestBody String data){
        String userId = gson.fromJson(data,Map.class).get("userId").toString();
        User user = userService.findUserById(userId);
        if(user == null) throw new UserException(UserEnum.USER_NOT_EXIST);
        return new ResponseInfo(user);
    }


    @RequestMapping("/is_login")
    public ResponseInfo isLogin(HttpSession httpSession){
        Object userId = httpSession.getAttribute("userId");
        if(userId==null)
            throw new UserException(UserEnum.USER_NOT_LOGIN);
        else
            return new ResponseInfo(new HashMap<String,String>()
            {{
                put("userId",userId.toString());
            }});
    }

}
