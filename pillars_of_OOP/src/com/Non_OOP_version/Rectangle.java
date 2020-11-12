package com.Non_OOP_version;

import java.util.Scanner;

public class Rectangle {
	
	float length;
	float breadth;
	float area;
	
	public void acceptInput(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the length");
		length=sc.nextFloat();
		System.out.println("Enter the breadth");
		breadth=sc.nextFloat();
	}
	
	public void compute() {
		 area=length*breadth;
	}
	
	public void disp(){
		System.out.println("area of rectangle is :"+area);
	}

}
