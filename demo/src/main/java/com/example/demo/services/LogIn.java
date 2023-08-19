package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class LogIn {
	
	private boolean isLoggedIn;

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

}
