package com.caps.dev.spring.core.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Config.class);
		/*Performance performance = ctx.getBean("singing",Performance.class);
		performance.perform();*/
		
		BlankDisc bd = ctx.getBean(BlankDisc.class);
		bd.playTrack(15);
	}
}