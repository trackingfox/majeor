package com.ABC.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class DateInsertApply {

	private static String SQLINSERTQUERY = "insert into employee values(?,?,?,?,?,?)";

	public static void main(String[] args) {

		// Resources used in the application
		FileInputStream fileInputStream = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Scanner scanner = null;
		SimpleDateFormat sdf1 = null, sdf2 = null;
		Date udob = null, udoj = null, udom = null;
		java.sql.Date sqlDob = null, sqlDoj = null, sqlDom = null;

		// local variables used in application
		int id = 0;
		String name = null;
		String dob = null;
		String dom = null;
		String doj = null;
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

				System.out.println("Enter the name:: ");
				name = scanner.next();

				System.out.println("enter the dob(DD-MM-YYYY):: ");
				dob = scanner.next();

				System.out.println("enter the dom(MM-DD-YYYY):: ");
				dom = scanner.next();

				System.out.println("enter the doj(YYYY-MM-DD):: ");
				doj = scanner.next();

				System.out.println("Enter the address:: ");
				address = scanner.next();

				sdf1 = new SimpleDateFormat("DD-MM-YYYY");
				if (sdf1 != null) {

					udob = sdf1.parse(dob);

					if (udob != null) {
						sqlDob = new java.sql.Date(udob.getTime());
					}

				}

				sdf2 = new SimpleDateFormat("MM-DD-YYYY");
				if (sdf2 != null) {

					udob = sdf2.parse(dom);
					if (udom != null) {
						sqlDom = new java.sql.Date(udom.getTime());
					}

				}

				sqlDoj = java.sql.Date.valueOf(doj);

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
					preparedStatement = connection.prepareStatement(SQLINSERTQUERY);

					if (preparedStatement != null) {

						// setting the values to placeholder

						preparedStatement.setInt(1, id);
						preparedStatement.setString(2, name);
						preparedStatement.setDate(3, sqlDob);
						preparedStatement.setDate(4, sqlDom);
						preparedStatement.setDate(5, sqlDoj);
						preparedStatement.setString(6, address);

						// Step4:Executing the PreparedStatement object
						int rowAffected = preparedStatement.executeUpdate();

						if (rowAffected == 0) {
							System.out.println("Insertion failed");
						} else {
							System.out.println("row inserted successfully!!");
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
			} catch (ParseException e) {
				e.printStackTrace();
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
