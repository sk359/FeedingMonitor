package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
@Component
public class InterceptorRegistry implements WebMvcConfigurer {
 
    @Autowired
    private IpAddressInterceptor ipAddressInterceptor;
    @Override
    public void addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry registry) {
 
        registry.addInterceptor(ipAddressInterceptor);
    }
}
