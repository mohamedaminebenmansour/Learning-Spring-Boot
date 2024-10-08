package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Lazy
public class CricketCoach implements Coach {
	
	public CricketCoach() {
		System.out.println("In constractor: +"+ getClass().getSimpleName());

	}
	@PreDestroy
	public void enfOfSomthing() {
		System.out.println("@PreDestroy:"+ getClass().getSimpleName());
	}
	@PostConstruct
	public void doSomthing() {
		System.out.println("@PostConstruct:"+ getClass().getSimpleName());
	}
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
