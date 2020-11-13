package com.OOP_version;

public class Launch {

	public static void main(String[] args) {
		
		Geometry g=new Geometry();
		Rectangle r=new Rectangle();
		Square q=new Square();
		Circle c=new Circle();
		
		g.permit(r);///polymorphism see class geometry where we have 
		g.permit(q);////used parent type reference S5hape to access the methods.
		g.permit(c);
		

	}

}
