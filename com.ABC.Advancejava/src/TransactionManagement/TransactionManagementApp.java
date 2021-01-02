package TransactionManagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import util.JdbcUtil;

public class TransactionManagementApp {

	public static void main(String[] args) {
		
		Connection connection =null;
		Statement statement=null;
		Scanner scanner =null;
		int srcAccNo=0;
		int destAccNo=0;
		int balance=0;
		boolean flag = false;
		
		try {
			scanner = new Scanner(System.in);
			if(scanner !=null) {
				System.out.print("Enter the source accNo:: ");
				srcAccNo = scanner.nextInt();
				
				System.out.print("Enter the destination accNo:: ");
				destAccNo = scanner.nextInt();
				
				System.out.print("Enter the amount to be transferred:: ");
				balance = scanner.nextInt();
			}
		}catch(Exception e) {
			
		}

		connection =JdbcUtil.getConnection();
		if(connection !=null) {
			try {
				//Disabling the autocommit nature of connection object
				connection.setAutoCommit(false);
				
				statement=connection.createStatement();
				
				if(statement!=null) {
					
					String HDFCQuery="";
					String ICICIQuery="";
					
					System.out.println(HDFCQuery);
					System.out.println(ICICIQuery);
					
					statement.addBatch("");
					statement.addBatch("");
					
					int[] results = statement.executeBatch();
					
					for(int row : results ) {
						if(row ==0) {
							
							//Error in the execution of DBE
							flag=false;
							connection.rollback();
							break;
						}
					}
					
					
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				if(scanner !=null) {
					scanner.close();
				}
				
				try {
					//check if the flag value is true or not
					if(flag == true) {
						//some problem so revert the operation
						connection.rollback();
						System.out.println("Fund transfer not successful............");
					}else {
						//successful so complete the operations
						connection.commit();
						System.out.println("Fund transfer successful---------------");
					}
					if(statement !=null) {
						statement.close();
					}
					//Closing the connection object
					JdbcUtil.closeConnection(connection);;
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
