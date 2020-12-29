package com.ABC.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Statement_oracle {
	
	private static final String SQLSELECTQUERY=null;

	/*
	 * WAP to check whether the login credentials are valid or not.
	 */
	

	public static void main(String[] args) {
		
		//Resources used in the application
		FileInputStream fileInputStream=null;
		Connection connection =null;
		Statement statement=null;
		Scanner scanner =null;
		ResultSet resultSet=null;
		
		String uname=null;
		String pwd=null;
		
		//Took the filename from the command line
		String fileName="D:\\Workspace\\com.ABC.servlet\\src\\com\\ABC\\resources\\"+args[0];
		System.out.println(fileName);
		
		try {
			scanner = new Scanner(System.in);
			//taking the inputs from the user to execute the query
			
			if(scanner !=null) {
				System.out.println("Enter the username :: ");
				uname=scanner.next();
				
				System.out.println("Enter the password:: ");
				pwd= scanner.next();
				
				
				
			}
		
		
		
		//Get the information from the filename to java code
		try {
			fileInputStream=new FileInputStream(fileName);
			
			//create the objects of the properties file to get data
			Properties properties= new Properties();
			properties.load(fileInputStream);
			
			
			//use keys of the properties file to get the value
			String url = properties.getProperty("jdbc.url");
			String username = properties.getProperty("jdbc.username");
			String password = properties.getProperty("jdbc.password");
			
			System.out.println("The url is : "+url);
			System.out.println("The password is : "+password);
			System.out.println("The username is : "+username);
			
			
		
		//step1:Establish the connection b/w java app and database
		connection = DriverManager.getConnection(url, username, password);
	
		
		if(connection != null) {
			
			//Srep2: Creating the statement object to sent the query to DB
			statement=connection.createStatement();
			
			if(statement !=null) {
				
				String SQLSELECTQUERY="select count(*) from login where username= '"+uname+"' and password='" +pwd+ "'";
				System.out.println("Query executed by DBE is :: "+SQLSELECTQUERY);
				
				//Step 3: Execute the query by sending to DBE
				resultSet=statement.executeQuery(SQLSELECTQUERY);
				
				//step 4: processing the resultset object
				if(resultSet.next()==false) {
					int rowCount = resultSet.getInt(1);
					if(rowCount==0) {
						System.out.println("Login credentials are incorrect");
						
					}else {
						System.out.println("Login successful");
					}
				}
			}
				
		}
		
			
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}}finally {
					//closing the iostream resources
					try {
						
						if(fileInputStream !=null) {
							fileInputStream.close();
						}
						
					}catch(Exception e) {
						System.out.println("the cause of the exception is : "+e.getMessage());
					}
					
					try {
						if(scanner !=null) {
							scanner.close();
						}
					}catch(Exception exception) {
						System.out.println("the cause of the exception is : "+exception.getMessage());
					}
			
					//Step5:Close the jdbc resources
					try {
						
						if(resultSet !=null) {
							resultSet.close();
						}
					}catch(SQLException sqlException) {
						System.out.println("The cause of the exception is::"+sqlException.getMessage());
					}
			
					try {
						if(statement !=null) {
							statement.close();
						}
					}catch(SQLException sqlException) {
						System.out.println("The cause of the exception is::"+sqlException.getMessage());
					}
				
			}
	}

}


	
