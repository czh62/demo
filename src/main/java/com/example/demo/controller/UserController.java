package com.example.demo.controller;

import com.example.demo.domain.response.Response;
import com.example.demo.domain.user.UserLoginReq;
import com.example.demo.domain.user.userRegisterReq;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Log4j2
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public Response<Map<String, Object>> login(@RequestBody UserLoginReq userLoginReq) {
        try {
            Response<String> result = userService.login(userLoginReq);
            if (result.isSuccess()) {
                Map<String, Object> map = new HashMap<>();
                map.put("token", result.getData());
                return Response.success(map);
            }else {
                return Response.error(result.getMessage());
            }
        }catch (Exception e) {
            log.error("login error:{}",e.getMessage());
            return Response.error("登录失败");
        }
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public Response<String> register(@RequestBody userRegisterReq userRegisterReq) {
        return Response.success("暂未开放注册功能");
    }

}
