package com.caps.dev.spring.core.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class CarConfig {

	//@Bean(name="car")
	public Car getCar(Engine eng) {
		Car c = new Car();
		c.setBrand("BMW");
		c.setName("320L");
		c.setEng(getEngine());
		
		
		return c;
	}
	
	//@Bean(name="engine")
	public Engine getEngine() {
		return new V2Engine();
	}
	
}
