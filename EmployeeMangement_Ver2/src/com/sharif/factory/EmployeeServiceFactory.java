package com.sharif.factory;

import com.sharif.service.EmployeeService;
import com.sharif.service.EmployeeServiceImpl;

public class EmployeeServiceFactory {
	private static EmployeeService empService;
	static {
		empService = new EmployeeServiceImpl();
	}
	public static EmployeeService getEmployeeService() {
		return empService;
	}
}
