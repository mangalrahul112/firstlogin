package com.caps.dev.spring.core.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(PersonConfig.class);
		Person p = ctx.getBean("person",Person.class);
		p.getJob().doJob();

		ctx.close();
		
	}
}