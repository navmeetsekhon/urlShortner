package com.giovanni.urlShortner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class UrlShortnerApplication {

	public static void main(String[] args) {
		System.out.println("hello");
		SpringApplication.run(UrlShortnerApplication.class, args);
	}

}
