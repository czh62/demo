package com.example.demo.interceptor;

import com.example.demo.utils.BaseContext;
import com.example.demo.utils.JwtUtil;

import io.micrometer.common.util.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,
                             @NonNull HttpServletResponse response,
                             @NonNull Object handler) throws Exception {
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(response);
        String token = request.getHeader("Authorization");
        if (StringUtils.isBlank(token)) {
            wrapper.sendRedirect("/error/token");
            return false;
        }
        if (!JwtUtil.verifyToken(token)) {
            wrapper.sendRedirect("/error/token");
            return false;
        }
        BaseContext.removeCurrentToken();
        BaseContext.setCurrentToken(token);
        return true;
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest request,
                           @NonNull HttpServletResponse response,
                           @NonNull Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request,
                                @NonNull HttpServletResponse response,
                                @NonNull Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}