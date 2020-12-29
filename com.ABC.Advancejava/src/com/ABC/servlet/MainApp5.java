//package com.ABC.servlet;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Properties;
//import java.util.Scanner;
//
//public class MainApp5 {
//	
//	private static String SQLINSERTQUERY="insert into person(name,age,email) values(?,?,?)";
//	
//
//	public static void main(String[] args) {
//		
//		//Resources used in the application
//	
//		Connection connection =null;
//		PreparedStatement preparedStatement=null;
//		Scanner scanner =null;
//		
//		int sid=0;
//		String sname=null;
//		int sage=0;
//		String email=null;
//		
//		//database credentials
//		String url="jdbc:mysql://localhost:3306/abc";
//		String username="root";
//		String password="root";
//		
//		
//		
//		try {
//			scanner = new Scanner(System.in);
//			//taking the inputs from the user to execute the query
//			
//			if(scanner !=null) {
////				System.out.println("Enter the id of the student :: ");
////				sid=scanner.nextInt();
//				
//				System.out.println("Enter the name:: ");
//				sname= scanner.next();
//				
//				System.out.println("enter the age:: ");
//				sage= scanner.nextInt();
//				
//				System.out.println("enter the mailid:: ");
//				email= scanner.next();
//				
//			}
//		
//		
//		
//		
//		int count=3;
//		
//		if(connection != null) {
//			
//			//step2:Create the preparedStatement object
//			preparedStatement = connection.prepareStatement(SQLINSERTQUERY);
//			
//		if(preparedStatement !=null) {
//				
//			for(int i=1;i<=count;i++) {	
//				
//				if(scanner!=null) {
//					System.out.println("enter the id: ");
//					sid=scanner.nextInt();
//					
//					System.out.println("Enter the name:: ");
//					sname=scanner.next();
//					
//					System.out.println("enter the age:: ");
//					sage=scanner.nextInt();
//				
//				preparedStatement.setInt(1,sid);
//				preparedStatement.setString(2,sname);
//				preparedStatement.setInt(3,sage);
//				}
//				
//				//Step4:Executing the PreparedStatement object
//				int rowAffected = preparedStatement.executeUpdate();
//				
//				if(rowAffected ==0) {
//					System.out.println("Insertion failed");
//				}else {
//					System.out.println("row inserted successfully!!");
//				}
//				
//			}
//		}
//		}
//		
//			}catch(FileNotFoundException e) {
//				e.printStackTrace();
//			}catch(IOException e) {
//				e.printStackTrace();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}}finally {
//				//closing the iostream resources
//				try {
//					if(fileInputStream !=null) {
//						fileInputStream.close();
//					}
//				}catch(Exception e) {
//					System.out.println("the cause of the exception is : "+e.getMessage());
//				}
//		
//				//Step5:Close the jdbc resources
//				
//				try {
//					if(preparedStatement !=null) {
//						preparedStatement.close();
//					}
//				}catch(SQLException sqlException) {
//					System.out.println("The cause of the exception is ::"+ sqlException.getMessage());
//				}
//				
//				try {
//					if(connection !=null) {
//						connection.close();
//					}
//				}catch(SQLException sqlException) {
//					System.out.println("The cause of the exception is::"+sqlException.getMessage());
//				}
//				
//				try {
//					if(scanner !=null) {
//						scanner.close();
//					}
//				}catch(Exception exception) {
//					System.out.println("The cause of the exception is::"+exception.getMessage());
//				}
//			}
//
//		}
//}
