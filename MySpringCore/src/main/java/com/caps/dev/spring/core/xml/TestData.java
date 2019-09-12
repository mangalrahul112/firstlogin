package com.caps.dev.spring.core.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestData {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("/DataConfig.xml");
		Data d = ctx.getBean("data",Data.class);
		System.out.println(d.getSub());
		for(String s:d.getInfo())
		{
			System.out.println(s);
		}
		for(Job j:d.getJobs())
		{
			j.doJob();
		}
		ctx.close();
	}
}