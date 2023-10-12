package com.example.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Order(1)
@Component
public class ApiInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    // 在请求处理之前进行拦截逻辑
    return true; // 返回 true 表示继续处理请求，返回 false 表示拦截请求
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    System.out.println("uri: " + request.getRequestURI());
    // 在请求处理之后、视图渲染之前进行拦截逻辑
    if (request.getRequestURI().startsWith("/api")) {
      System.out.println("starts with api");
      // 如果是以 "/api" 开头的路径，则设置响应类型为 JSON
      response.setContentType("application/json");
    }
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    // 在整个请求完成后进行拦截逻辑
  }
}