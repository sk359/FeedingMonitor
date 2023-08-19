package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This single annotation is equivalent to using @Configuration, 
// @EnableAutoConfiguration, and @ComponentScan.
@SpringBootApplication 
public class FeedingMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedingMonitorApplication.class, args);
	}

}
