package com.example.config;

import com.example.interceptor.ApiInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
@PropertySource("file.properties")
public class AppConfig implements WebMvcConfigurer {

  @Value("${file.dir}")
  String dir;
  
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    System.out.println("dir is: " + dir);

      registry.addResourceHandler("/static/**")
              .addResourceLocations("file:" + dir);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(new ApiInterceptor())
              .addPathPatterns("/**"); // 拦截所有路径
              // .excludePathPatterns("/login"); // 排除指定路径
  }
}
