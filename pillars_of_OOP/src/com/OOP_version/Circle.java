package com.OOP_version;

import java.util.Scanner;

public class Circle extends Shape{
	
	//we have inherited the data member area
	//inherited method disp()
	//overiden method acceptInput() and compute()
	private float radius;
	
	public void acceptInput(){
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the radius");
		radius=sc.nextFloat();
		
	}
	
	public void compute() {
		area=(float) (3.14*radius*radius);
	}
	
	

}
