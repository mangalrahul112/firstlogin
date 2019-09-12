package com.caps.dev.spring.core.mix;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({LionConfig.class})
@ImportResource({"classpath:/DogConfig.xml"})
public class MonkeyConfig {
	
	@Bean("monkey")
	public Monkey getMonkey() {
		Monkey m = new Monkey();
		m.setName("Rambo");
		m.setColor("Grey");
		return m;
	}
}
