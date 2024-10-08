package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BaseballCoach implements Coach {

	public BaseballCoach() {
		System.out.println("In constractor: +"+ getClass().getSimpleName());
	}
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice";
    }
}
