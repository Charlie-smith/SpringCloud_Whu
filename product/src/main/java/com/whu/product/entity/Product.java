package com.whu.product.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@DynamicUpdate
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer productId;

    private String productUserId;

    private String productName;

    private Double productPrice;

    private Integer productStock;

    private String productType;

    private String productDescribe;

    private String gameName;

    private String gameServer;

    private String gameOperating;

    private Date createTime;

    private Date updateTime;
}
