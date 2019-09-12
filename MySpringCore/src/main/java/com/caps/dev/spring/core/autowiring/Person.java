package com.caps.dev.spring.core.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("person")
public class Person{
	private String name="Rah";
	private String email="Abc@gmail";
	
	@Autowired(required=false)
	//@Qualifier("developer")
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
	
}
