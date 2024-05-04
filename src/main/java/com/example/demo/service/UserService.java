package com.example.demo.service;

import com.example.demo.domain.response.Response;
import com.example.demo.domain.user.UserBean;
import com.example.demo.domain.user.UserLoginReq;

import java.util.List;

public interface UserService {
    Response<UserBean> getCurrentUser();

    Response<String> login(UserLoginReq userLoginReq);

    Response<List<UserBean>> getUserList();

    Response<Integer> getUserCount();


}
