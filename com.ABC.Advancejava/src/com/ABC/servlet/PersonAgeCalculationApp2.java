package com.ABC.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

public class PersonAgeCalculationApp2 {

	// private static String SQLINSERTQUERY = "select datediff(now(),dob)/365.25
	// from employee where id=?";
	// private static String SQLINSERTQUERY = "select datediff(now(),dob) as age
	// from employee where id=?";
	private static String SQLINSERTQUERY = "select dob as age from employee where id=?";

	public static void main(String[] args) {

		// Resources used in the application
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Scanner scanner = null;

		// local variables used in the application
		int id = 0;

		// DB credentials information
		String url = "jdbc:mysql://localhost:3306/abc";
		String username = "root";
		String password = "root";

		try {
			scanner = new Scanner(System.in);
			// taking the inputs from the user to execute the query

			if (scanner != null) {
				System.out.println("Enter the id of the student :: ");
				id = scanner.nextInt();

			}

			// step1:Establish the connection b/w java app and database
			connection = DriverManager.getConnection(url, username, password);

			if (connection != null) {

				// step2:Create the preparedStatement object
				preparedStatement = connection.prepareStatement(SQLINSERTQUERY);

				if (preparedStatement != null) {

					// step3: setting the values to placeholder
					preparedStatement.setInt(1, id);

					// step4:Executing the query
					resultSet = preparedStatement.executeQuery();

					if (resultSet != null) {

						// step5:Processing the query
						if (resultSet.next()) {
							
							
							//Collecting java.sql.Date object in java.util.Date object
							java.util.Date udate = resultSet.getDate(1);
							
							//Got time in milisec from java.util.Date object
							long udobMs = udate.getTime();
							
							//Got Currenttime in milisec from java.util.Date object
							Date currentDate = new Date();
							long cdateMS = currentDate.getTime();

							System.out.println(udobMs);
							System.out.println(cdateMS);
							
							//long year=(cdateMS-udobMs)/(1000*60*60*24*365.25f);
							System.out.println("the age is :: "+(cdateMS-udobMs)/(1000*60*60*24*365.25f));

						} else {
							System.out.println("Record not available for the given id:: " + id);

						}
					}

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

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
