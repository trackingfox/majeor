package com.ABC.servlet;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataApplication {

	public static void main(String[] args) throws SQLException {
		
		Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","root");
		
		Statement statement =connection.createStatement();
		ResultSet resultSet =statement.executeQuery("select * from product");
		
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		
		DatabaseMetaData dbMetaData = connection.getMetaData();
		System.out.println("The implementation class object of connection is :: "+connection.getClass().getName());
		System.out.println("The implementation class object of DatabaseMetaData is :: "+dbMetaData.getClass().getName());

		if(resultSetMetaData !=null) {
			
			

			

		}
	}

}
