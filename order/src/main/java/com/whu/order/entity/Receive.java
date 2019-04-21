package com.whu.order.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class Receive {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer ReceiveId;

    private String iphone;

    private String qq;

    private String gameServer;

    private String gameRoleName;

    private String gameAccount;

    private String gamePassword;

    private String gameRank;

    private Date createTime;

    private Date updateTime;
}
