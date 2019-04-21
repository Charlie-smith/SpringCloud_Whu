package com.whu.order.vo;

import com.whu.order.enums.OrderEnum;
import lombok.Data;

@Data
public class ResponseInfo {

    private Integer code;

    private String msg;

    private Object data;

    public ResponseInfo(){
    }

    public ResponseInfo(OrderEnum OrderEnum, Object data){
        this.code = OrderEnum.getCode();
        this.msg = OrderEnum.getMessage();
        this.data = data;
    }

    //成功时返回
    public ResponseInfo(Object data){
        this.code = OrderEnum.SUCCESS.getCode();
        this.msg = OrderEnum.SUCCESS.getMessage();
        this.data = data;
    }
}
