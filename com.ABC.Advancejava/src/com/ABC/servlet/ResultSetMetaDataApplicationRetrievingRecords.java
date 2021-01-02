package com.ABC.servlet;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataApplicationRetrievingRecords {

	public static void main(String[] args) throws SQLException {
		
		Connection connection =null;
		Statement statement =null;
		ResultSet resultSet =null;
		ResultSetMetaData resultSetMetaData=null;
		
		try {
		connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","root");
		
		if(connection !=null) {
			statement = connection.createStatement();
			
			if(statement!=null) {
				resultSet =statement.executeQuery("select * from product");
				
				if(resultSet !=null) {
				 resultSetMetaData = resultSet.getMetaData();
				 
				 	if(resultSetMetaData != null) {
				 		while(resultSet.next() != false) {
				 			for(int i=1;i<= resultSetMetaData.getColumnCount(); i++) {
				 				System.out.println(resultSet.getString(1)+" ");
				 			}
				 			System.out.println();
				 		}
			
				 	}
		
				}
		
	
			}		
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
			}catch(SQLException e) {
				System.out.println("the cause of the exception :: "+e.getMessage());
			}
			
			try {
				if(statement!=null) {
					statement.close();
				}
			}catch(SQLException e) {
				System.out.println("the cause of the exception :: "+e.getMessage());
			}
			
			try {
				if(connection !=null) {
					connection.close();
				}
			}catch(SQLException e) {
				System.out.println("the cause of the exception :: "+e.getMessage());
			}
		

}
			
}
		
}

	


