package com.ABC.servlet;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatementMetaDataApp {

	static String INSERT_QUERY ="insert into products(?,?,?,?)";
	public static void main(String[] args) throws SQLException {
		
		Connection connection =null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet =null;
		ResultSetMetaData resultSetMetaData=null;
		ParameterMetaData parameterMetaData =null;
		
		try {
		connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","root");
		
		if(connection !=null) {
			preparedStatement = connection.prepareStatement(INSERT_QUERY);
			
			if(preparedStatement!=null) {
				 parameterMetaData = preparedStatement.getParameterMetaData();
		
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
				if(preparedStatement!=null) {
					preparedStatement.close();
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

	


