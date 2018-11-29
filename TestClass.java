package com.mtc.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
		
		MessageService messageService =  applicationContext.getBean(MessageService.class);
		
		System.out.println(messageService.greetMessage());

	}

}
