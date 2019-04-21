package com.whu.user.exception;

import com.whu.user.enums.UserEnum;
import lombok.Data;

@Data
public class UserException extends RuntimeException {

    private Integer code;

    public UserException(UserEnum userEnum) {
        super(userEnum.getMessage());

        this.code = userEnum.getCode();
    }

    public UserException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
