package com.OOP_version;

import java.util.Scanner;

public class Rectangle extends Shape{
	
	//we have inherited the data member area
		//inherited method disp()
		//overiden method acceptInput() and compute()
	
	private float length;
	private float breadth;
	
	public void acceptInput(){
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the length");
		length=sc.nextFloat();
		System.out.println("enter the breadth");
		breadth=sc.nextFloat();
	
	}
	
	public void compute() {
		area=length*breadth;
	}
	
}
