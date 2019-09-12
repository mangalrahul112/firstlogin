package com.caps.dev.spring.core.autowiring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component("developer")
//@Primary
public class SoftwareDeveloper implements Job {
	public void doJob() {
		System.out.println("Codes Codes Codes...");
	}
}
