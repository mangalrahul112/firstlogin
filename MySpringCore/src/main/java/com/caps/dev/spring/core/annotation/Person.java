package com.caps.dev.spring.core.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Person implements BeanNameAware,BeanFactoryAware,
					ApplicationContextAware,BeanPostProcessor,
					InitializingBean,DisposableBean{
	private String name;
	private String email;
	private Job job;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", job=" + job + "]";
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("Before Init");
		return null;
	}
	@Override
	public void setApplicationContext(ApplicationContext name) throws BeansException {
		System.out.println("App Context is:"+name.toString());
	}
	@Override
	public void setBeanFactory(BeanFactory name) throws BeansException {
		System.out.println("Bean Factory is:"+name.toString());
	}
	@Override
	public void setBeanName(String name) {
		System.out.println("Bean Name is:"+name);
		
	}
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("After Init");
		return null;
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Bean has Destroyed");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Properties are set");
	}
}
