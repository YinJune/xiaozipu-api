package com.xiaozipu.client.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/19 21:08
 * @description:
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
//    @Value("")
    public List<String> validatePatterns;
//    @Value("")
    public List<String> excludePatterns;
    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/anon/**");
    }
}
