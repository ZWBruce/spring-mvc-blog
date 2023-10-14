package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
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
}
