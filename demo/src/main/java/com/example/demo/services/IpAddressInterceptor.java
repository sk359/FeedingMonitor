package com.example.demo.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

// https://fullstackdeveloper.guru/2020/07/13/how-to-log-ip-addresses-of-incoming-requests-to-a-spring-boot-app-in-a-centralized-way/comment-page-1/

@Component
public class IpAddressInterceptor implements HandlerInterceptor {
	
	// Sets Client IP address and redirects to login if not logged in
	
	@Autowired
	private LogIn loginService; 
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
 
 
        String ipAddress = request.getHeader("X-Forward-For");
 
        if(ipAddress== null){ 
            ipAddress = request.getRemoteAddr();
            loginService.setCurrentClientIP(ipAddress);
        } 
        
        // Filter out login requests and static files:
        if (request.getRequestURI().equals("/") || request.getRequestURI().contains(".")) {
        	return true;
        }        
        
        if (loginService.isIPLoggedIn()) {
        	return true;
        } else {
        	// redirect to login if not logged in: 
        	String encodedRedirectURL = response.encodeRedirectURL(request.getContextPath() + "/");
            response.setStatus(303);
            response.setHeader("Location", encodedRedirectURL);
            return false;
        }        
        
    }

}
