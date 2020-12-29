package com.ABC.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class NonSelectQuery {

	public static void main(String[] args) {
		
		//Resources used in the application
		FileInputStream fileInputStream=null;
		Connection connection =null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		//Took the filename from the command line
		String fileName="D:\\Workspace\\com.ABC.servlet\\src\\com\\ABC\\resources\\"+args[0];
		System.out.println(fileName);
		
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
			
			
//			} catch (FileNotFoundException e) {
//				
//				e.printStackTrace();
//			} catch(IOException e) {
//				e.printStackTrace();
//			}finally {
//				
//				try {
//					if(fileInputStream !=null) {
//						fileInputStream.close();
//					}
//				}catch (Exception e) {
//					System.out.println("The cause of the exception is : "+e.getMessage());
//				}
//			}
//			
		
		//step1:Establish the connection b/w java app and database
		connection = DriverManager.getConnection(url, username, password);
		
		if(connection != null) {
			//step2:Create the statement object
			statement=connection.createStatement();
			
			if(statement !=null) {
				
//				statement.executeQuery("insert into student values(33,'samuels',45)");
//				int rowAffected =statement.getUpdateCount();
//				System.out.println("No of rows affected in the database is :: "+rowAffected);  these are applicable for ORACLE database.
				
				int dbInfo=statement.executeUpdate("create table cricketer (id int primary key, name varchar 20");
				System.out.println("Database got created and its value is ::"+dbInfo);
				
		}
		
	}

			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				//closing the iostream resources
				try {
					if(fileInputStream !=null) {
						fileInputStream.close();
					}
				}catch(Exception e) {
					System.out.println("the cause of the exception is : "+e.getMessage());
				}
		
		//Step5:Close the jdbc resources
		
		try {
			if(statement !=null) {
				connection.close();
			}
		}catch(SQLException sqlException) {
			System.out.println("The cause of the exception is ::"+ sqlException.getMessage());
		}
		
		
	}

	}
}
