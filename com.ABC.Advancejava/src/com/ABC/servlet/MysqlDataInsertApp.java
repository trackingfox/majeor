package com.ABC.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlDataInsertApp {

	private static final String SQLINSERTQUERY="insert into andhrabank(name,accno,balance) values(?,?,?)";

	public static void main(String[] args) {
		
		//Resources used in the application
		Connection mysqlConnection = null;
		Connection oracleConnection = null;
		ResultSet oracleResultSet=null;
		PreparedStatement mysqlPreparedStatement =null;
		Statement oracleStatement =null;
		
		//local variables used in the application
		String oracleUrl="jdbc:oracle:thin:@localhost:1521:xe";
		String oracleUser="root";
		String oraclePwd="root";
		
		String mysqlUrl = "jdbc:mysql://localhost:3306/abc";
		String mysqlUser = "root";
		String mysqlPwd= "root";
		int count=0;
		
		try {
			oracleConnection=DriverManager.getConnection(oracleUrl,oracleUser,oraclePwd);
			mysqlConnection =DriverManager.getConnection(mysqlUrl,mysqlUser,mysqlPwd);
			
			if(oracleConnection !=null) {
				
				oracleStatement =oracleConnection.createStatement();
				
				if(oracleStatement!=null ) {
					
					String sqlSelectQuery="select name,accno,balance from unionbank";
					oracleResultSet=oracleStatement.executeQuery(sqlSelectQuery);
					
					mysqlPreparedStatement=mysqlConnection.prepareStatement(SQLINSERTQUERY);
					
					if(oracleResultSet !=null && mysqlPreparedStatement !=null) {
						while(oracleResultSet.next()) {
							
							String name = oracleResultSet.getString(1);
							int accNo=oracleResultSet.getInt(2);
							float balance=oracleResultSet.getFloat(3);
							
							mysqlPreparedStatement.setString(1, name);
							mysqlPreparedStatement.setInt(2, accNo);
							mysqlPreparedStatement.setFloat(3, balance);
							
							mysqlPreparedStatement.executeUpdate();
							count++;
						}
						System.out.println(count+"records transferred from union bank to andhra bank...");
					}
				}
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(oracleStatement!=null) {
					oracleStatement.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(oracleStatement!=null) {
					oracleStatement.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(mysqlPreparedStatement!=null) {
					mysqlPreparedStatement.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
