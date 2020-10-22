package com.sharif.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sharif.bean.Employee;
import com.sharif.factory.ConnectionFactory;



public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String add(Employee emp) {
		String status = "";
		
	try {
			
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from test.emp where EMPNO=" 
											+emp.getEmpno());
			boolean b = rs.next();
			
			if (b == true) {
				status = "Employee Already Exists";
			} 
			else {
				String mystatement = "insert into emp values(" + emp.getEmpno() + ",'"
									+ emp.getEname() + "',"
									+ emp.getSal() + ")"; // This is prone to SQL injection // do not use string 
				
				System.out.println( "my SQL statement " + mystatement);
				
				int rowcount = st.executeUpdate(mystatement);
				
				if (rowcount == 1) {
					status = "Employee inserted successfully";
					} 
				else {
					status = "Insertion failure";
					}
				}
		}
	
		catch (Exception e) {
			status = "Insertion failure";
			e.printStackTrace();
		}
	
		return status;
	}

	@Override
	public Employee search(int empno) {
		Employee emp = new Employee();
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from test.emp where EMPNO=" + empno);
			boolean b = rs.next();
			if (b == true) {
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setSal(rs.getInt("sal"));
			} else {
				emp = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	
	@Override
	public String update(int empno, Employee emp) {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
	
		String status = "";
		try {
			
			myConn = ConnectionFactory.getConnection();
			// create SQL update statement
						String sql = "update test.emp "
									+ "set EMPNO=?, ENAME=?, SAL=? "
									+ "where EMPNO="+empno;
						
						// prepare statement
						myStmt = myConn.prepareStatement(sql);
						
						// set params
						myStmt.setInt(1, emp.getEmpno());
						myStmt.setString(2, emp.getEname());
						myStmt.setInt(3, emp.getSal());
							
						// execute SQL statement
						myStmt.execute();
						
						System.out.println(emp.toString());
						
						status="Updated sucessfully";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	
	}

	@Override
	public String delete(int empno) {
		
		String status = "";
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		
		try {
		
			
			// get connection to database
			 myConn = ConnectionFactory.getConnection();
			
			// create sql to delete student
			String sql = "delete from test.emp where EMPNO="+empno;
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			//myStmt.setInt(1,empno);
			
			// execute sql statement
			myStmt.execute();
			
			status="Deleted sucessfully";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
  return status;
}

	@Override
   public List<Employee> list() {
		
		List<Employee> employee = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			 myConn = ConnectionFactory.getConnection();
			
			// create sql statement
			String sql = "select * from test.emp order by EMPNO";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			
			
			// process result set
			while (myRs.next()) {
				
				// create new employee object
				Employee emp = new Employee();
				
				// retrieve data from result set row
				emp.setEmpno(myRs.getInt("EMPNO"));
				emp.setEname(myRs.getString("ENAME"));
				emp.setSal(myRs.getInt("SAL"));
				
							
				// add it to the list of employees
				employee.add(emp);				
			}
			
					
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return employee;	
	
}
	
}	
	