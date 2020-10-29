package com.sharif;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
	
	private String dbUrl="jdbc:mysql://localhost:3306/test";
	private String dbUname="root";
	private String dbPassword="root";
	private String dbDriver="com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con=null;
		try {
			con=DriverManager.getConnection(dbUrl,dbUname,dbPassword);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public String insert(Member member)
	{
		loadDriver(dbDriver);
		Connection con=getConnection();
		String result="Data entered succesfully";
		String sql="insert into member values(?,?,?,?)";
		
		PreparedStatement ps;
		try {
		ps=con.prepareStatement(sql);
		ps.setString(1, member.getUname());
		ps.setString(2, member.getPassword());
		ps.setString(3, member.getEmail());
		ps.setString(4, member.getPhone());
		ps.executeUpdate();
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    	result="Data not entered";
		
	}
	return result;

}
}
