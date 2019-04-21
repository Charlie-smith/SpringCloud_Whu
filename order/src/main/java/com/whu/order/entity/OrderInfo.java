package com.whu.order.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class OrderInfo {
    @Id
    private String orderId;

    private String userId;

    private Integer productId;

    private Integer receiveId;

    private Integer productNum;

    private String orderStatus;

    private Date createTime;

    private Date updateTime;
}
