package com.money.pojo;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class User {
    private Integer id;
    private String email;
    private String phoneNum;
    private String password;
    private String code;
    private String nickName;//昵称
    private String sex;
    private String birthday;
    private String address;
    private String imgUrl;
    private Timestamp createTime;

}
