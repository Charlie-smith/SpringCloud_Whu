package com.whu.order.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    SUCCESS(0, "交易成功"),
    FAIL(1,"交易失败")
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
