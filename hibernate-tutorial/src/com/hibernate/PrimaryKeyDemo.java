package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.package1.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		//create session factory
				SessionFactory factory =new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try {
							
					//create 3 student object
					System.out.println("Creating 3 student object...");
					Student tempStudent1 = new Student("paul","wall","paul@code.com");
					Student tempStudent2 = new Student("marium","hazra","kill@code.com");
					Student tempStudent3 = new Student("george","wall","georl@code.com");
					//start a transaction
					session.beginTransaction();
					//save the student object
					System.out.println("saving the students");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					//commit transaction
					
					session.getTransaction().commit();
					System.out.println("done");
					
					
				}
				finally {
					factory.close();
				}
				
		
	}

}
