package com.java.springboot.sms;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.text.NumberFormat;

@SpringBootTest
class StudentManagementSystemApplicationTests {

	// Here, the Spring Application Context is tested whether own beans are added to it or not and how we are going to use it.

	// AutoWiring by Type - This type of AutoWiring is called as AutoWiring by Type.
	// There should be only Type of the class in the Spring Application Context
	@Autowired
	private ApplicationContext ctx;

	// If there are two bean with the same Type of the class then the AutoWiring fails.
	// If the AutoWiring fails because of the reason having two beans with the same Type
	// it is possible to tell the Spring Application Context to which bean to use by giving the bean name using @Qualifier
	// This is called as AutoWiring by Name.
	@Autowired
	@Qualifier("getDefaultCurrencyFormat")
	private NumberFormat nf;

	@Test
	void contextLoads() {

		// To get the Number of beans available in the Spring Application Context.
		int count = ctx.getBeanDefinitionCount();
		System.out.println("Total Number of Beans available in Spring Application Context :: " + count);

		// To get all the beans which are available in Spring Application Context
		String[] beanNames = ctx.getBeanDefinitionNames();

		for (String bean: beanNames) {
			System.out.println(bean);
		}
	}

	// This is to test whether our own bean is working properly or not
	@Test
	public void defaultCurrencyFormatTest() {
		double amount = 12345678.90123456;
		System.out.println("Amount Default Currency :: " + nf.format(amount));
	}

	@Test
	public void germanCurrencyFormatTest() {
		double amount = 12345678.90123456;
		// It is possible to get the Bean from the Spring Application Context using getBean method on Application Context object.
		// getBean will take two arguments:
		//		1. Name of the Bean
		//		2. Type of the Class
		NumberFormat germanCurrencyFormat = ctx.getBean("getGermanyCurrencyFormat", NumberFormat.class);

		System.out.println("Amount Default Currency :: " + germanCurrencyFormat.format(amount));
	}


}
