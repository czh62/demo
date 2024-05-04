package com.example.demo.domain.user;

import lombok.Data;

@Data
public class UserLoginReq {
    private String userName;
    private String password;
}
