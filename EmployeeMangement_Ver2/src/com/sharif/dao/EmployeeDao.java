package com.sharif.dao;

import java.util.List;

import com.sharif.bean.Employee;

public interface EmployeeDao {
	public List<Employee> list();
	public String add(Employee emp);
	public Employee search(int empno);
	public String update(int empno,Employee emp);
	public String delete(int empno);
	
}
