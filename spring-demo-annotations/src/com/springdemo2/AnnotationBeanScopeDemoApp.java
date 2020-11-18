package com.springdemo2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load the spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		//get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		//check if they are the same
				boolean result =(theCoach== alphaCoach);
				
				//print out the results
				System.out.println("\nPointing to the same object "+result);
				System.out.println("\nMemory location for the coach: "+theCoach);
				System.out.println("\nMemory location for alphacoach: "+alphaCoach+"\n");
				
				//close the context
				context.close();
		

	}

}
