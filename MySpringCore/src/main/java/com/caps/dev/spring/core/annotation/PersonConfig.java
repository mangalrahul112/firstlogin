package com.caps.dev.spring.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration

public class PersonConfig {
	
	@Bean(name="person")
	
	public Person getPerson(@Qualifier("discoJob")Job job) {
		Person p = new Person();
		p.setName("Abc");
		p.setEmail("aa88@gmail.com");
		p.setJob(job);
		
		return p;
	}
	
	@Bean(name="discoJob")
	public Job getDancer() {
		return new DiscoDancer();
	}
	
	@Bean(name="testJob")
	@Primary
	public Job getTestingJob() {
		return new SoftwareTester();
	}
	
	@Bean(name="devJob")
	@Primary
	public Job getDeveloperJob() {
		Job job = new SoftwareDeveloper();
		return job;
	}
}