package com.ABC.servlet;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.tomcat.util.http.fileupload.IOUtils;

public class ArtistInfoRetrieve {

	private static String SQLSELECTQUERY = "select * from employee where id=?";

	public static void main(String[] args) {

		// Resources used in the application
		InputStream imageis = null;
		InputStream videois = null;
		FileOutputStream imageos = null;
		FileOutputStream videoos = null;
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Scanner scanner = null;

		// local variables used in application
		int id = 0;
		String name = null;
		String address = null;
		String imagePath = null;
		String videoPath = null;
		String url = "jdbc:mysql://localhost:3306/abc";
		String username = "root";
		String password = "root";

		try {
			scanner = new Scanner(System.in);

			if (scanner != null) {
				// taking the inputs from the user to execute the query

				System.out.println("Enter the id of the student :: ");
				id = scanner.nextInt();

			}

			// step1:Establish the connection b/w java app and database
			connection = DriverManager.getConnection(url, username, password);

			if (connection != null) {

				// step2:Create the preparedStatement object
				preparedStatement = connection.prepareStatement(SQLSELECTQUERY);

				if (preparedStatement != null) {

					// set preparedStatement value For ? params
					preparedStatement.setInt(1, id);
					// Step3:Executing the query
					resultSet = preparedStatement.executeQuery();

					if (resultSet != null) {
						id = resultSet.getInt(1);
						name = resultSet.getString(2);
						address = resultSet.getString(3);
						imageis = resultSet.getBinaryStream(4);
						videois = resultSet.getBinaryStream(5);

						String imagepath = "sachin.jpg";
						imageos = new FileOutputStream(imagepath);
						String videopath = "sample.mp4";
						videoos = new FileOutputStream(videopath);

						// use the stream to read the data coming from DBE
						int data = imageis.read();

						// loop until the data we are receiving is not equal to -1
						while (data != -1) {
							// using the output stream write image data to the desired location
							imageos.write(data);
							data = imageis.read();
						}

						IOUtils.copy(videois, videoos);

					}

					System.out.println("id:: " + id + "Name::" + name + "Address:: " + address);
					System.out.println("image retrieval is completed and saved as :: " + imagePath);
					System.out.println("video retrieval is completed and saved as :: " + videoPath);
				} else {
					System.out.println("Record not available for the given id:: " + id);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// closing the iostream resources
			try {
				if (imageis != null) {
					imageis.close();
				}
				if (imageos != null) {
					imageos.close();
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
