package com.ABC.servlet;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMetaDataApplication {

	public static void main(String[] args) throws SQLException {
		
		Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","root");
		
		DatabaseMetaData dbMetaData = connection.getMetaData();
		System.out.println("The implementation class object of connection is :: "+connection.getClass().getName());
		System.out.println("The implementation class object of DatabaseMetaData is :: "+dbMetaData.getClass().getName());

		if(dbMetaData !=null) {
			
			System.out.println("DatabaseEngine name is ::"+dbMetaData.getDatabaseProductName());
			System.out.println("DatabaseEngine name is ::"+dbMetaData.getDatabaseProductVersion());
			System.out.println("DatabaseEngine Version is ::"+dbMetaData.getDriverVersion());
			System.out.println("DatabaseEngine Major Version is ::"+dbMetaData.getDatabaseMajorVersion());
			System.out.println("DatabaseEngine Minor Version is ::"+dbMetaData.getDatabaseMinorVersion());
			System.out.println("DatabaseEngine SQL Keywords is ::"+dbMetaData.getSQLKeywords());
			System.out.println("DatabaseEngine Math functions is ::"+dbMetaData.getNumericFunctions());
			System.out.println("DatabaseEngine DateTime is ::"+dbMetaData.getTimeDateFunctions());

			

			

		}
	}

}
