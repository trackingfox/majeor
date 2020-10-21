package com.sharif.service;

import com.sharif.bean.Employee;

public interface EmployeeService {

	public String addEmployee(Employee emp);
	public Employee searchEmployee(int empno);
	public String updateEmployee(Employee emp);
	public String delete(int empno);
}
