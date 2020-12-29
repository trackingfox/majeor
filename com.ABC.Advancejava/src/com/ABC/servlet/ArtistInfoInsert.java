package com.ABC.servlet;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ArtistInfoInsert {

	private static String SQLINSERTQUERY = "insert into abc.artist_info values(?,?,?,?,?)";

	public static void main(String[] args) {

		// Resources used in the application
		FileInputStream ifis = null;
		FileInputStream vfis = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Scanner scanner = null;
		
		

		// local variables used in application
		int id = 0;
		String name = null;
		String address = null;
		String imagePath=null;
		String videoPath=null;
		String url="jdbc:mysql://localhost:3306/abc";
		String username="root";
		String password="root";

		

		try {
			scanner = new Scanner(System.in);
			// taking the inputs from the user to execute the query

			if (scanner != null) {
				System.out.println("Enter the id of the student :: ");
				id = scanner.nextInt();
				System.out.println("Enter the name of the student :: ");
				name = scanner.next();
				System.out.println("Enter the address of the student :: ");
				address = scanner.next();
				System.out.println("Enter the location of the image :: ");
				imagePath = scanner.next();
				System.out.println("Enter the location of the video :: ");
				videoPath = scanner.next();
				
				ifis= new FileInputStream(imagePath);
				vfis= new FileInputStream(videoPath);
					
			}

			
			
				// step1:Establish the connection b/w java app and database
				connection = DriverManager.getConnection(url, username, password);

				if (connection != null) {

					// step2:Create the preparedStatement object
					preparedStatement = connection.prepareStatement(SQLINSERTQUERY);

					if (preparedStatement != null) {
						
						if(ifis!=null && vfis!=null) {
						//Step3: Setting the values to placeholder
						preparedStatement.setInt(1, id);
						preparedStatement.setString(2, name);
						preparedStatement.setString(3, address);
						preparedStatement.setBinaryStream(4, ifis);
						preparedStatement.setBinaryStream(5, vfis);
						
						int rowAffected= preparedStatement.executeUpdate();
						
						if(rowAffected==1) {
							System.out.println("Insertion Successful!!!!");
						}else {
							System.out.println("Record failed to insert.....");
						}
						
					}
				}
			}

		}catch (Exception e) {
				e.printStackTrace();
			
		} finally {
			// closing the iostream resources
			try {
				if (ifis != null) {
					ifis.close();
				}
				if (vfis != null) {
					vfis.close();
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
