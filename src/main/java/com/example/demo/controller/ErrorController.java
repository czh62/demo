package com.example.demo.controller;

import com.example.demo.domain.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/token")
    public Response<String> errorToken() {
        return Response.error(401, "Token expired or invalid");
    }
}
