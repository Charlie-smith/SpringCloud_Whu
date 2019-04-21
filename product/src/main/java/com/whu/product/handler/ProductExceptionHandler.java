package com.whu.product.handler;

import com.whu.product.exception.ProductException;
import com.whu.product.vo.ResponseInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(value = ProductException.class)
    @ResponseBody
    public Object handlerUserException(ProductException e){
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setCode(e.getCode());
        responseInfo.setMsg(e.getMessage());
        responseInfo.setData(null);
        return responseInfo;
    }
}
