package com.caps.dev.spring.core.xml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("/PersonConfig.xml");
//		Person p = ctx.getBean("person",Person.class);
		Person p = ctx.getBean("person",Person.class);
		System.out.println(p.getName());
		p.setName("abc");
		Person p1 = ctx.getBean("person",Person.class);
		System.out.println("Name is:"+p1.getName());
		p.getJob().doJob();
		/*System.out.println("Total Beans are: "+ctx.getBeanDefinitionCount());
		String[] names = ctx.getBeanDefinitionNames();
		for(String s:names)
		{
			System.out.println(s);
		}*/
		ctx.close();
		
	}
}