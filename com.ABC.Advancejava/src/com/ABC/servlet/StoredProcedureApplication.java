package com.ABC.servlet;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class StoredProcedureApplication {

	private static final String GET_PRODUCT_BY_NAME = "{call GET_PRODUCT_BY_NAME(?,?,?)}";

	public static void main(String[] args) {
		
			//Resources used in the application 
			Connection connection = null;
			CallableStatement cst=null;
			PreparedStatement preparedStatement =null;
			ResultSet resultSet=null;
			Scanner scanner = null;
			
			//local variables used in the application
			int id=0;
			
			// DB credentials information
			String url = "jdbc:mysql://localhost:3306/abc";
			String username = "root";
			String password = "root";
			
			//step1:Establish the connection between java app and database
			
			try {
				
				scanner=new Scanner(System.in);
				if(scanner!=null) {
					System.out.println("Enter the id :: ");
					id=scanner.nextInt();
				}
				
				connection =DriverManager.getConnection(url,username,password);
				
				if(connection !=null) {
					cst=connection.prepareCall(GET_PRODUCT_BY_NAME);
					
					if(cst!=null) {
						//setting the input parameters 
						cst.setInt(1, id);
						
						//setting the output parameters
						cst.registerOutParameter(2, Types.INTEGER);
						cst.registerOutParameter(2, Types.VARCHAR);
						
						//Execute the stored procedure by making a call to DBE
						cst.execute();
						
						//Retrieving based on getXXX(int position)
						System.out.println("The product cost is :: "+cst.getInt(2));
						System.out.println("The product name is :: "+cst.getString(3));
						
						
					}
					
				}
				
				
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				//closing the scanner stream
				if(scanner!=null) {
					scanner.close();
				}
				
				//Closing jdbc objects
				try {
					
					if(cst!=null) {
						cst.close();
					}
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
				try {
					if(connection !=null) {
						connection.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			

	}

}
}	
