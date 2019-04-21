package com.whu.product.vo;

import com.whu.product.enums.ProductEnum;
import lombok.Data;

@Data
public class ResponseInfo {

    private Integer code;

    private String msg;

    private Object data;

    public ResponseInfo(){

    }

    public ResponseInfo(ProductEnum productEnum, Object data){
        this.code = productEnum.getCode();
        this.msg = productEnum.getMessage();
        this.data = data;
    }

    //成功时返回
    public ResponseInfo(Object data){
        this.code = ProductEnum.SUCCESS.getCode();
        this.msg = ProductEnum.SUCCESS.getMessage();
        this.data = data;
    }
}
