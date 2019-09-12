package com.caps.dev.spring.core.xml;

public class Person {
	private String name;
	private String email;
	private Job job;
	
	public Person()
	{
		
	}
	/*public Person(String name, String email, Job job) {
		this.name = name;
		this.email = email;
		this.job = job;
	}*/
	public void myCustomInit()
	{
		System.out.println("Init is running...");
	}
	
	public void myCustomDestroy()
	{
		System.out.println("Destroy is running...");
	}
	
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
