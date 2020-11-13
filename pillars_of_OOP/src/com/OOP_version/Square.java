package com.OOP_version;

import java.util.Scanner;

public class Square extends Shape{
	
	//we have inherited the data member area
		//inherited method disp()
		//overriden method acceptInput() and compute()
	
	private float length;
	
	public void acceptInput(){
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the length");
		length=sc.nextFloat();		
	
	}
	
	public void compute() {
		area=length*length;
	}

}
