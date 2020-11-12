package com.Non_OOP_version;

import java.util.Scanner;

public class Circle {
	float area;
	int radius;
	
	public void acceptInput(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the radius");
		radius=sc.nextInt();
				
	}
	
	public void compute() {
		area=(float) (3.14*radius*radius);
		
	}
	
	public void disp(){
		System.out.println("area of the circle"+area);
		
	}

}
