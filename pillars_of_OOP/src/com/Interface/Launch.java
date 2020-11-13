package com.Interface;

public class Launch {

	public static void main(String[] args) {
		
		Calculator c=new Calculator();
		
		Compute ptr;
		AdvCompute aptr;
		c.add();
		c.sub();
		c.mul();
		c.div();
		
		ptr=(Compute) c;
		aptr=(AdvCompute) c;
		ptr.add();
		ptr.sub();
		
		((Calculator)(ptr)).mul();
		
		aptr.mul();
		aptr.div();
		aptr.add();
		aptr.sub();
		

	}

}
