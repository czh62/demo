package com.example.demo.service.impl;

import com.example.demo.domain.response.Response;
import com.example.demo.domain.user.UserBean;
import com.example.demo.domain.user.UserLoginReq;
import com.example.demo.service.UserService;
import com.example.demo.utils.BaseContext;
import com.example.demo.utils.JwtUtil;
import io.micrometer.common.util.StringUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;


import java.util.List;

import static com.example.demo.config.SystemConst.USER_MAP;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Override
    public Response<UserBean> getCurrentUser() {
        String token = BaseContext.getCurrentToken();
        if (StringUtils.isBlank(token)) {
            log.error("token 为空，无法获取当前用户");
            return Response.error("token 为空，无法获取当前用户");
        } else if (!JwtUtil.verifyToken(token)) {
            log.error("token 无效，无法获取当前用户");
            return Response.error("token 无效，无法获取当前用户");
        } else {
            UserBean userBean = USER_MAP.get(JwtUtil.getUserName(token));
            if (userBean == null) {
                log.error("未找到当前用户信息");
                return Response.error("未找到当前用户信息");
            }
            return Response.success(userBean);
        }
    }

    @Override
    public Response<String> login(UserLoginReq userLoginReq) {
        if (userLoginReq == null) {
            log.error("用户信息为空，无法登录");
            return Response.error("用户信息为空，无法登录");
        } else if (StringUtils.isBlank(userLoginReq.getUserName()) || StringUtils.isBlank(userLoginReq.getPassword())) {
            log.error("用户名或密码为空，无法登录");
            return Response.error("用户名或密码为空，无法登录");
        }


        userLoginReq.setPassword(new String(Base64.decodeBase64(userLoginReq.getPassword())));

        UserBean userBean = USER_MAP.get(userLoginReq.getUserName());
        if (userBean == null) {
            log.error("未找到用户信息");
            return Response.error("未找到用户信息");
        }
        if (userBean.getPassword().equals(userLoginReq.getPassword())) {
            log.info("登录成功");
            String token = JwtUtil.createToken(userLoginReq.getUserName());
            BaseContext.setCurrentToken(token);
            return Response.success(token);
        }
        log.error("用户名或密码错误，无法登录");
        return Response.error("用户名或密码错误，无法登录");
    }

    @Override
    public Response<List<UserBean>> getUserList() {
        // TODO: 权限校验
        return Response.success(USER_MAP.values().stream().toList());
    }

    @Override
    public Response<Integer> getUserCount() {
        // TODO: 权限校验
        return Response.success(USER_MAP.size());
    }
}
