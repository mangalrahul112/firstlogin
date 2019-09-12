package com.caps.dev.spring.core.autowiring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		/*AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(PersonConfig.class);*/
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("PersonConfig.xml");
		Person p = (Person) ctx.getBean("person",Person.class);
		System.out.println(p.getName());
		/*p.getJob().doJob();*/
		
		ctx.close();
		
	}
}