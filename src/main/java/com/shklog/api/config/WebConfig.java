package com.shklog.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /* 경로 패턴 사용 시 /api/**
           모든 경로 허용 시 /**
           특정 경로 허용 시 /posts, /comment 등
        */
        registry.addMapping("/**") // CORS를 허용할 API 경로
                .allowedOrigins("http://localhost:3000") // React 앱의 URL
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true); // 필요에 따라 true로 설정
    }
}
