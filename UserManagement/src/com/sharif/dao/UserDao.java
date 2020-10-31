package com.sharif.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sharif.bean.User;

public class UserDao {

	
	private String jdbcUrl="jdbc:mysql://localhost:3306/test";
	private String jdbcUsername="root";
	private String jdbcPassword="root";
	private String jdbcDriver="com.mysql.cj.jdbc.Driver";
	
	private static final String INSERT_USERS_SQL="INSERT INTO users"+" (name,email,country) VALUESt"
					+"(?,?,?);";
	private static final String SELECT_USER_BY_ID="select id,name,email,country from users where id=?";

	private static final String SELECT_ALL_USERS="select * from users";

	private static final String DELETE_USERS_SQL="delete from users where id=?;";
	
	private static final String UPDATE_USERS_SQL="update users set name = ?,email=?,country=? where id=?;";
	
	public UserDao() {
		
	}

	protected Connection getConnection(){
		Connection connection=null;
		try {
			Class.forName(jdbcDriver);
			connection=DriverManager.getConnection(jdbcUrl,jdbcUsername,jdbcPassword);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	//insert user 
	public void insertUser(User user)throws SQLException{
		System.out.println(INSERT_USERS_SQL);
		try(Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)){
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getCountry());
			System.out.println(ps);
			ps.executeUpdate();		
		}
		catch(SQLException e) {
			printSQLException(e);
		}
	}
	
	
	//select user by id
	public User selectUser(int id) {
		User user=null;
		//establishing connection
		
		try(Connection connection = getConnection();
			//create a statement using connection object
				PreparedStatement ps=connection.prepareStatement(SELECT_USER_BY_ID);){
			ps.setInt(1, id);
			System.out.println(ps);
			//execute the query or update query
			ResultSet rs=ps.executeQuery();
			
			//process the result set object
			while(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				user=new User(id,name,email,country);
				
			}	
		}catch(SQLException e) {
			printSQLException(e);
		}
		return user;
			
	}
	
	
	//select all users
	public List<User>selectAllUsers(){
		
		//using try with resources to avoid closing resources(boiler plate code)
		List<User>users =new ArrayList<>();
		try(Connection connection = getConnection();
				//create a statement using connection object
					PreparedStatement ps=connection.prepareStatement(SELECT_ALL_USERS);){
				
				System.out.println(ps);
				//execute the query or update query
				ResultSet rs=ps.executeQuery();
				
				//process the result set object
				while(rs.next()) {
					int id=rs.getInt("id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String country = rs.getString("country");
					users.add(new User(id,name,email,country));
					
				}	
			}catch(SQLException e) {
				printSQLException(e);
			}
			return users;
				
	}
		
	
	
	
	//update user
	
	public boolean updateUser(User user)throws Exception{
		boolean rowUpdated;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);){
			System.out.println("updated User:"+statement);
			statement.setString(1, user.getName());
			statement.setString(2, user.getName());
			statement.setString(3, user.getName());
			statement.setInt(4, user.getId());
			
			rowUpdated=statement.executeUpdate()>0;
			
		}
		return rowUpdated;
	}
	
	//delete user
	
	public boolean deleteUser(int id)throws SQLException{
		boolean rowDeleted;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);){
			statement.setInt(1, id);
			rowDeleted=statement.executeUpdate()>0;
		}
		return rowDeleted;
	}
	
	
	private void printSQLException(SQLException ex) {
		for(Throwable e: ex) {
			if(e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState:"+((SQLException) e).getSQLState());
				System.err.println("Error Code:"+((SQLException) e).getErrorCode());
				System.err.println("Message: "+e.getMessage());
				Throwable t=ex.getCause();
				while(t!=null) {
					System.out.println("Cause: "+t);
					t=t.getCause();
				}

			}
		}
	}
}	
	
