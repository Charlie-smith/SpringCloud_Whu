package com.whu.product.enums;

import lombok.Getter;

@Getter
public enum ProductEnum {
    SUCCESS(0, "成功"),
    PRODUCT_NOT_EXIST(1,"商品不存在"),





    ;



    private Integer code;

    private String message;

    ProductEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
