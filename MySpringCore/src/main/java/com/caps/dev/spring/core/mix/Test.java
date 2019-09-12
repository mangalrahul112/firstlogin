package com.caps.dev.spring.core.mix;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(MonkeyConfig.class);
		/*ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("/DogConfig.xml");*/
		String[] beans = ctx.getBeanDefinitionNames();
		for(String bean:beans) {
			System.out.println(bean);
		}
		ctx.close();
		
	}
}