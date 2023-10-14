package com.example.interceptor;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class ApiInterceptor implements HandlerInterceptor {
  private static final Logger logger = Logger.getGlobal();

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    logger.info("preHandle preHandle");
    // 在请求处理之前进行拦截逻辑
    return true; // 返回 true 表示继续处理请求，返回 false 表示拦截请求
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    System.out.println("uri: " + request.getRequestURI());
    logger.info("uri: " + request.getRequestURI());
    // 在请求处理之后、视图渲染之前进行拦截逻辑
    if (request.getRequestURI().startsWith("/api")) {
      logger.info("starts with api");
      // 如果是以 "/api" 开头的路径，则设置响应类型为 JSON
      response.setContentType("application/json");
    }
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    // 在整个请求完成后进行拦截逻辑
  }
}