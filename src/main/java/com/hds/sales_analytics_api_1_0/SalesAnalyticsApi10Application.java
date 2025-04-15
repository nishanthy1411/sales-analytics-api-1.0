package com.hds.sales_analytics_api_10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SalesAnalyticsApi10Application {

	public static void main(String[] args) {
		SpringApplication.run(SalesAnalyticsApi10Application.class, args);
	}
	
	@GetMapping("/hi")
	public String user() {
		return "Hello";
	}

}
