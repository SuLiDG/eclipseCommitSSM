package com.df.ssm.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;

@Data
public class UserInfo {
    private Long id;

    private Integer roleId;

    private String name;

    private String pwd;

    private String realName;

    private String qq;

    private Boolean sex;

    @JSONField(format="yyyy年MM月dd日")
    @DateTimeFormat(pattern="yyyy年MM月dd日")
    private Date birthdate;

    private String cardId;

    private String tel;

    private String email;

    private String address;

    private Date createTime;

    
}