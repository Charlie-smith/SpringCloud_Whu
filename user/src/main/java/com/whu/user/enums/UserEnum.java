package com.whu.user.enums;

import lombok.Getter;

@Getter
public enum UserEnum {
    SUCCESS(0, "成功"),
    LOGIN_FAIL(1,"登陆失败"),
    EMAIL_REPEAT(2,"邮箱已经注册"),
    USER_NOT_EXIST(3,"用户不存在"),
    MAIL_SEND_FAIL(4,"邮件发送失败"),
    USER_NOT_LOGIN(5,"用户未登陆"),


    ;



    private Integer code;

    private String message;

    UserEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
