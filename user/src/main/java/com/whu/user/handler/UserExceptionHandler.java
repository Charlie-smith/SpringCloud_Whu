package com.whu.user.handler;

import com.whu.user.entity.User;
import com.whu.user.exception.UserException;
import com.whu.user.vo.ResponseInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = UserException.class)
    @ResponseBody
    public Object handlerUserException(UserException e){
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setCode(e.getCode());
        responseInfo.setMsg(e.getMessage());
        responseInfo.setData(null);
        return responseInfo;
    }
}
