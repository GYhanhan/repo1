package com.star.interceptor;

import com.star.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PublicInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        User user=(User)request.getSession().getAttribute("user");
        if (user.getType()!=1) {
            response.sendRedirect("/templates/index");
            return false;
        }
        return true;
    }
}
