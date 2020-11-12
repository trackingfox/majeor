package com.Non_OOP_version;

public class Launch {

	public static void main(String[] args) {
		
		Rectangle r = new Rectangle();
		Circle c=new Circle();
		Square q=new Square();
		
		r.acceptInput();
		r.compute();
		r.disp();
		
		c.acceptInput();
		c.compute();
		c.disp();
		
		q.acceptInput();
		q.compute();
		q.disp();
	}

}
