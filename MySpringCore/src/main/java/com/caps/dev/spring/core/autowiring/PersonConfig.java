package com.caps.dev.spring.core.autowiring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class PersonConfig {
	
	@Bean(name="list")
	public List<String> getList()
	{
		return new ArrayList<String>();
	}
}