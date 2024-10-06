package demo;

import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach {

	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice for 15 min";
	}

}
