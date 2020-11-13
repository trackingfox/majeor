package com.OOP_version;

public abstract class Shape {
	
	float area;
	
	public abstract void acceptInput();
	public abstract void compute();
	
	public void disp() {
		System.out.println("Area "+area);
	}
	
		
	

}
