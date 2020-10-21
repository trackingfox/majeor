package com.sharif.dao;

import com.sharif.bean.Employee;

public interface EmployeeDao {
	public String add(Employee emp);
	public Employee search(int empno);
	public String update(Employee emp);
	public String delete(int empno);
}
