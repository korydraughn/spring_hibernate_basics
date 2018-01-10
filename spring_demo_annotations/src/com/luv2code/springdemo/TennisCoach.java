package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// Define a default constructor.
	public TennisCoach()
	{
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	// Define my init method.
	@PostConstruct
	public void doMyStartupStuff()
	{
		System.out.println(">> TennisCoach: inside method - doMyStartupStuff");
	}
	
	// Define my destroy method.
	@PreDestroy
	public void doMyCleanupStuff()
	{
		System.out.println(">> TennisCoach: inside method - doMyCleanupStuff");
	}
	
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService theFortuneService)
//	{
//		System.out.println(">> TennisCoach: inside setter method - doSomeCrazyStuff");
//		fortuneService = theFortuneService;
//	}
	
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService)
//	{
//		fortuneService = theFortuneService;
//	}

	@Override
	public String getDailyWorkout()
	{
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
	}

}
