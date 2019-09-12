package com.caps.dev.spring.core.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackCounter {
	
	int trackNumber;
	
	@Pointcut("execution( ** com.caps.dev.spring.core.aop.BlankDisc.playTrack(int)) "
			+ "&& args(track)")
	public void trackPlayed(int track) {}
	
	@Before("trackPlayed(track)")
	public void countTrack(int track) {
		System.out.println("Recording the Track Nubmer: "+track);
	}
	
}