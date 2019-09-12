package com.caps.dev.spring.core.annotation;

public class V2Engine implements Engine{

	@Override
	public void start() {
		System.out.println("Car has Strated");
	}

	@Override
	public void stop() {
		System.out.println("Car has stopped");
	}

}
