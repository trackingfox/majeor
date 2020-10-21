package com.sharif.service;

import com.sharif.bean.Employee;
import com.sharif.dao.EmployeeDao;
import com.sharif.factory.EmployeeDaoFactory;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public String addEmployee(Employee emp) {
		EmployeeDao empdao=EmployeeDaoFactory.getEmployeeDao();
		String status=empdao.add(emp);
		return status;
	}

	@Override
	public Employee searchEmployee(int empno) {
		EmployeeDao empdao=EmployeeDaoFactory.getEmployeeDao();
		Employee emp=empdao.search(empno);
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) {
		
		return null;
	}

	@Override
	public String delete(int empno) {
		
		return null;
	}

}
