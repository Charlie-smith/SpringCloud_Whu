package com.whu.order.handler;

import com.whu.order.exception.OrderException;
import com.whu.order.vo.ResponseInfo;
import org.omg.CORBA.UserException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class OrderExceptionHandler {

    @ExceptionHandler(value = OrderException.class)
    @ResponseBody
    public Object handlerUserException(OrderException e){
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setCode(e.getCode());
        responseInfo.setMsg(e.getMessage());
        responseInfo.setData("");
        return responseInfo;
    }
}
