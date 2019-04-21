package com.whu.order.exception;

import com.whu.order.enums.OrderEnum;
import lombok.Data;

@Data
public class OrderException extends RuntimeException {
    private Integer code;

    public OrderException(OrderEnum OrderEnum) {
        super(OrderEnum.getMessage());

        this.code = OrderEnum.getCode();
    }

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
