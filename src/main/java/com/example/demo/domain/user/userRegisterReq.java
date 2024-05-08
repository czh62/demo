package com.example.demo.domain.user;

import com.example.demo.domain.enums.UserTypeEnum;
import lombok.Data;

@Data
public class userRegisterReq {
    private Integer id;
    private String userName;
    private String password;
    private UserTypeEnum userType;
    private String email;
    private String phone;
}
