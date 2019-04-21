package com.whu.order.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum OrderEnum {

    SUCCESS(0, "成功"),
    USER_NOT_LOGIN(1,"用户未登陆"),
    SERVICE_PRODUCT_CALL_FAIL(2,"商品服务调用失败")



    ;



    private Integer code;

    private String message;

    OrderEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
