package com.caps.dev.core.java;

public class Test {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("ABc Def");
		p.setEmail("abc@gmail.com");
		
		SoftwareDeveloper job = new SoftwareDeveloper();
		p.setJob(job);
		p.getJob().doJob();
		SoftwareTester testJob = new SoftwareTester();
		p.setJob(testJob);
		p.getJob().doJob();
		DiscoDancer bestJob = new DiscoDancer();
		p.setJob(bestJob);
		p.getJob().doJob();
		
	}
}