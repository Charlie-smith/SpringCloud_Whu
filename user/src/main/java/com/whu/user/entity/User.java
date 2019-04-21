package com.whu.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class User {
    @Id
    private String userId;

    private String userEmail;

    private String userName;

    private String password;

    private Date createTime;

    private Date updateTime;
}
