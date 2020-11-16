package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.package1.Student;

public class ReadStudentDemo {
	
	public static void main(String args[]) {
		
		//create session factory
		SessionFactory factory =new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
					
			//create a student object
			System.out.println("Creating a new student object...");
			Student tempStudent = new Student("daffy","wall","daffy@code.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			
			//My new code
			
			
			//find out the student's id: primary key
			System.out.println("saved student Generated id: "+tempStudent.getId());
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: "+tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("get complete: "+myStudent);
			
			//commit the transaction
			session.getTransaction().commit();
				
			System.out.println("done");
			
		}
		finally {
			factory.close();
		}
		
	}

}











