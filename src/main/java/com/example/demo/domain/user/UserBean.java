package com.example.demo.domain.user;

import com.example.demo.domain.enums.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {
    private Integer id;
    private String userName;
    private String password;
    private UserTypeEnum userType;
    private String email;
    private String phone;
}
