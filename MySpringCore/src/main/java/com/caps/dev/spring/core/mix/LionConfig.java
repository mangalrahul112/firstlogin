package com.caps.dev.spring.core.mix;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LionConfig {
	
	@Bean(name="lion")
	public Lion getLion() {
		Lion l = new Lion();
		l.setName("Simba");
		l.setColor("Golden Orange");
		return l;
	}
}