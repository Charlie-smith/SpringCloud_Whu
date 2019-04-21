package com.whu.user.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.whu.user.enums.UserEnum;
import lombok.Data;

@Data
@JsonInclude
public class ResponseInfo {

    private Integer code;

    private String msg;

    private Object data;

    public ResponseInfo(){

    }

    public ResponseInfo(UserEnum userEnum, Object data){
        this.code = userEnum.getCode();
        this.msg = userEnum.getMessage();
        this.data = data;
    }

    //成功时返回
    public ResponseInfo(Object data){
        this.code = UserEnum.SUCCESS.getCode();
        this.msg = UserEnum.SUCCESS.getMessage();
        this.data = data;
    }
}
