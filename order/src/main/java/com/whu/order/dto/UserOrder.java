package com.whu.order.dto;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Data
@Configuration
public class UserOrder {

    private String orderId;

    private Date updateTime;

    private String productName;

    private Double productPrice;

    private Integer productNum;

    private String orderStatus;
}
