package com.java.springboot.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.NumberFormat;
import java.util.Locale;

@SpringBootApplication
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	// Adding our own Beans to the Spring Application Context
	// @Bean Annotation is used to add our own beans
	@Bean
	public NumberFormat getDefaultCurrencyFormat() {
		return NumberFormat.getCurrencyInstance();
	}

	// Adding one more bean with the Same return type class
	// Adding this bean will fail AutoWiring in Test class
	// But this issue is going to resolve this in a different way
	@Bean
	public NumberFormat getGermanyCurrencyFormat() {
		return NumberFormat.getCurrencyInstance(Locale.GERMANY);
	}

}
