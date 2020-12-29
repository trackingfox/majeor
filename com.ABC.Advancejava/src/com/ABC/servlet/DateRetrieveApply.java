package com.ABC.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class DateRetrieveApply {

	private static String SQLSELECTQUERY = "select * from employee where id=?";

	public static void main(String[] args) {

		// Resources used in the application
		FileInputStream fileInputStream = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet=null;
		Scanner scanner = null;
		SimpleDateFormat sdf = null, sdf2 = null;
		Date udob = null, udoj = null, udom = null;
		java.sql.Date sqlDob = null, sqlDoj = null, sqlDom = null;
		

		// local variables used in application
		int id = 0;
		String name = null;
		String sdob = null;
		String sdom = null;
		String sdoj = null;
		String address = null;

		// Took the filename from the command line
		String fileName = "D:\\Workspace\\com.ABC.servlet\\src\\com\\ABC\\resources\\" + args[0];
		System.out.println(fileName);

		try {
			scanner = new Scanner(System.in);
			// taking the inputs from the user to execute the query

			if (scanner != null) {
				System.out.println("Enter the id of the student :: ");
				id = scanner.nextInt();
			}

			// Get the information from the filename to java code
			try {
				fileInputStream = new FileInputStream(fileName);

				// create the objects of the properties file to get data
				Properties properties = new Properties();
				properties.load(fileInputStream);

				// use keys of the properties file to get the value
				String url = properties.getProperty("jdbc.url");
				String username = properties.getProperty("jdbc.username");
				String password = properties.getProperty("jdbc.password");

				System.out.println("The url is : " + url);
				System.out.println("The password is : " + password);
				System.out.println("The username is : " + username);

				// step1:Establish the connection b/w java app and database
				connection = DriverManager.getConnection(url, username, password);

				if (connection != null) {

					// step2:Create the preparedStatement object
					preparedStatement = connection.prepareStatement(SQLSELECTQUERY);

					if (preparedStatement != null) {
						//setting the value to dynamic params(?)
						preparedStatement.setInt(1, id);
						
						//Step3: Execute the query
						resultSet =preparedStatement.executeQuery();
						
						if(resultSet !=null) {
							
							if(resultSet.next()!=false) {
								
								id=resultSet.getInt(1);
								name=resultSet.getString(2);
								
								sqlDob=resultSet.getDate(3);
								sqlDom=resultSet.getDate(4);
								sqlDoj=resultSet.getDate(5);
								
								address=resultSet.getString(6);
								
								sdf=new SimpleDateFormat("yyyy-MM-dd");
								
								sdob=sdf.format(sqlDob);
								sdom=sdf.format(sqlDom);
								sdoj=sdf.format(sqlDoj);
								
								System.out.println("------------------------------------------");
								
								System.out.println("id ::"+id+"Name:: "+name+ "dob::"+sdob+"dom:: "
													+sdom+"doj:: "+sdoj+"Address:: "+address);
								System.out.println("------------------------------------------");
								
								System.out.println("id ::"+id+"Name:: "+name+ "dob::"+sqlDob+"dom:: "
										+sqlDom+"doj:: "+sqlDoj+"Address:: "+address);
								
								
							}else {
								System.out.println("Record not available for the given id:: "+id);
							}
						}
					}
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} finally {
			// closing the iostream resources
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			} catch (Exception e) {
				System.out.println("the cause of the exception is : " + e.getMessage());
			}

			// Step5:Close the jdbc resources

			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException sqlException) {
				System.out.println("The cause of the exception is ::" + sqlException.getMessage());
			}

			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlException) {
				System.out.println("The cause of the exception is::" + sqlException.getMessage());
			}
		}

	}
}
