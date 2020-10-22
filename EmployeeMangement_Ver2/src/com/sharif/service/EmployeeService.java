package com.sharif.service;

import com.sharif.bean.Employee;

public interface EmployeeService {
	
	public void listEmployee();
	public String addEmployee(Employee emp);
	public Employee searchEmployee(int empno);
	public String updateEmployee(int empno,Employee emp);
	public String delete(int empno);
}
