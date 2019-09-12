package com.caps.dev.spring.core.autowiring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component("tester")
//@Primary
public class SoftwareTester implements Job {
	public void doJob() {
		System.out.println("Test Test Test...");
	}
}
