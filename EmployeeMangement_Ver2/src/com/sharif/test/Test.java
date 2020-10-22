package com.sharif.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.sharif.bean.Employee;
import com.sharif.factory.EmployeeServiceFactory;
import com.sharif.service.EmployeeService;

public class Test {

	public static void main(String[] args) {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.println("0:-LIST");
				System.out.println("1:-ADD");
				System.out.println("2:-SEARCH");
				System.out.println("3:-UPDATE");
				System.out.println("4:-DELETE");
				System.out.println("5:-EXIT");
				System.out.println("Enter Your Choice(0,1,2,3,4,5)  :");
				int option= Integer.parseInt(br.readLine());
				int empno,sal;
				String ename;
				EmployeeService empservice=EmployeeServiceFactory.getEmployeeService();
				Employee emp=null;
				switch(option) {
				
				case 0:
					empservice.listEmployee();
					break;
				case 1:
					System.out.println("Employee No  :");
					empno=Integer.parseInt(br.readLine());
					System.out.print("Employee Name  :");
					ename=br.readLine();
					System.out.print("Employee Salary  :");
					sal=Integer.parseInt(br.readLine());
					emp=new Employee();
					emp.setEmpno(empno);
					emp.setEname(ename);
					emp.setSal(sal);
					
					String status=empservice.addEmployee(emp);
					System.out.println("Status :"+status);
					break;
					
				case 2:
					System.out.println("Employee No  :");
					empno=Integer.parseInt(br.readLine());
					emp=empservice.searchEmployee(empno);
					if(emp==null) {
						System.out.println("employee doesn't exist");
					}
					else {
						System.out.println("Employees Record");
						System.out.println("-----------------------");
						System.out.println("Employee No :"+emp.getEmpno());
						System.out.println("Employee Name :"+emp.getEname());
						System.out.println("Employee Salary  :"+emp.getSal());					
					}
					
					break;
				case 3:
					System.out.println("Employee No  :");
					empno=Integer.parseInt(br.readLine());
					emp=empservice.searchEmployee(empno);
					if(emp==null) {
						System.out.println("employee doesn't exist");
					}
					else {
						System.out.println("Employees Record");
						System.out.println("-----------------------");
						System.out.println("Employee No :"+emp.getEmpno());
						System.out.println("Employee Name :"+emp.getEname());
						System.out.println("Employee Salary  :"+emp.getSal());
						
					
						//taking input for update
						
						System.out.println("Enter updated Employee No  :");
						empno=Integer.parseInt(br.readLine());
						System.out.print("Employee Name  :");
						ename=br.readLine();
						System.out.print("Employee Salary  :");
						sal=Integer.parseInt(br.readLine());
						emp=new Employee();
						emp.setEmpno(empno);
						emp.setEname(ename);
						emp.setSal(sal);
						
						String status1=empservice.updateEmployee(empno,emp);
						System.out.println("Status :"+status1);
											
					}
					break;
				case 4:
					System.out.println("Employee No  :");
					empno=Integer.parseInt(br.readLine());
					emp=empservice.searchEmployee(empno);
					if(emp==null) {
						System.out.println("employee doesn't exist");
					}
					else {
						String status2=empservice.delete(empno);
						System.out.println("Status :"+status2);
					}
					
					break;
				case 5:
					System.out.println("Thanks for using Employee Application");
					System.exit(0);
					break;
				default:
					System.out.println("Enter 1,2,3,4,5");
					
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
