package com.sharif.factory;

import com.sharif.dao.EmployeeDao;
import com.sharif.dao.EmployeeDaoImpl;

public class EmployeeDaoFactory {
	private static EmployeeDao empDao;
	static {
		empDao=new EmployeeDaoImpl();
	}
	public static EmployeeDao getEmployeeDao() {
		return empDao;
	}
}
