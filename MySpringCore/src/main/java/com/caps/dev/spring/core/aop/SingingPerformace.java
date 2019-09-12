package com.caps.dev.spring.core.aop;



public class SingingPerformace implements Performance {
	@Override
	public void perform() {
		System.out.println("Start Singing...");
		
		System.out.println("Ends Singing...");
	}
}