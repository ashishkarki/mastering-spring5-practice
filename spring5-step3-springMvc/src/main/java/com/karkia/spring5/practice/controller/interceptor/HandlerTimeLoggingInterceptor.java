package com.karkia.spring5.practice.controller.interceptor;

import org.jetbrains.annotations.NotNull;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerTimeLoggingInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull Object handler)
            throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    public void postHandle(
            HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull Object handler,
            @Nullable ModelAndView modelAndView)
            throws Exception {
        request.setAttribute("endTime", System.currentTimeMillis());
    }

    public void afterCompletion(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull Object handler,
            @Nullable Exception ex)
            throws Exception {
        var startTime = (Long) request.getAttribute("startTime");
        var endTime = (Long) request.getAttribute("endTime");

        response.addHeader("executionTime", String.valueOf(endTime - startTime));
    }
}
