package com.Non_OOP_version;

import java.util.Scanner;

public class Square {
	
	float length;
	float area;
	
	public void acceptInput(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the length");
		length=sc.nextFloat();
	}
	
	public void compute() {
		area=length*length;
		
	}
	
	public void disp(){
		System.out.println("area of square"+area);
		
	}

}
