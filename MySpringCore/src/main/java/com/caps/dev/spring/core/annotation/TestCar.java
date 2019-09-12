package com.caps.dev.spring.core.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestCar {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(CarConfig.class);
		Car c = ctx.getBean("car",Car.class);
		c.getEng().start();
		c.getEng().stop();
		
		
	}
}