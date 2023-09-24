package com.example.demo.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class LogIn {
	
	private boolean isLoggedIn;
	private String currentClientIP;
	private HashMap<String, Boolean> loggedInMap = new HashMap<String, Boolean>();

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		loggedInMap.put(this.currentClientIP, isLoggedIn);
		this.isLoggedIn = isLoggedIn;
	}
	
	public void setCurrentClientIP(String clientIP) {
		System.out.println(clientIP);
		this.currentClientIP = clientIP;
	}
	
	public boolean isIPLoggedIn() {
		Boolean isLoggedIn = this.loggedInMap.get(this.currentClientIP);
		if (isLoggedIn == null) {
			return false;
		}
		return isLoggedIn;
	}

}
