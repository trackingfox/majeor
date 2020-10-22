package com.sharif.service;

import java.util.List;

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
	public String updateEmployee(int empno, Employee emp) {
		EmployeeDao empdao=EmployeeDaoFactory.getEmployeeDao();
		String status=empdao.update(empno,emp);
		return status;
	}

	@Override
	public String delete(int empno) {
		EmployeeDao empdao=EmployeeDaoFactory.getEmployeeDao();
		String status=empdao.delete(empno);
		return status;
	}
	
	@Override
	public void listEmployee() {
		EmployeeDao empdao=EmployeeDaoFactory.getEmployeeDao();
		List<Employee> empl=empdao.list();
		System.out.println("EMPNO   "+"ENAME   "+"SAL");
		for(Employee e :empl)
		{
			System.out.println(e.getEmpno()+"  "+e.getEname()+"  "+e.getSal());
		}
		
	}
	

}
