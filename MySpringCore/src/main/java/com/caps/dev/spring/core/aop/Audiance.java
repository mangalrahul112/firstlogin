package com.caps.dev.spring.core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audiance {
	
	@Pointcut("execution(** com.caps.dev.spring.core.aop.Performance.perform(..))")
	public void performance() {}
	
//	
//	@Before("performance()")
//	public void silenceCellPhones() {
//		System.out.println("Silencing Cell Phones");
//	}
//	
//	@Before("performance()")
//	public void takeSeats() {
//		System.out.println("Taking Seats");
//	}
//	
//	@AfterReturning("performance()")
//	public void applause() {
//		System.out.println("Clap Clap Clap");
//	}
//	
//	@AfterThrowing("performance()")
//	public void demandRefund() {
//		System.out.println("Give my money back...You son of a B****");
//	}

	@Around("performance()")
	public void watchPerformace(ProceedingJoinPoint jp) {
		try {
			System.out.println("Silencing Cell Phones");
			System.out.println("Taking Seats");
			jp.proceed();
			System.out.println("Clap Clap Clap");
		} catch (Throwable e) {
			System.out.println("Slap Slap Slap...Give My Money Back");
		}
	}
}
