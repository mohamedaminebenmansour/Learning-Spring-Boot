package com.luv2code.springcoredemo.common;

public class SwimCoach implements Coach {
	
	public SwimCoach() {
		System.out.println("In constractor: +"+ getClass().getSimpleName());

	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swim 100 m as a warm up";
	}

}
