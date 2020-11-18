package com.springdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component			//using default bean id tennisCoach--1st char lower case
@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	//define default constructor
	public TennisCoach() {
		System.out.println(">>TennisCoach: inside default constructor");
	}
	
	//define a setter method
	/*@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">>TennisCoach: inside setFortuneService method");
		fortuneService=theFortuneService;
	}
	
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
  */
	
	/*@Autowired
	public void doSomeCrazyStuff(FortuneService theFortuneService) {
		System.out.println(">>TennisCoach: inside doSomeCrazyStuff method");
		fortuneService=theFortuneService;
	}*/
	
	
	
	
	@Override
	public String getDailyWorkout() {
		
		return "Practice your volley" ;
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
