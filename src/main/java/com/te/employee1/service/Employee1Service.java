package com.te.employee1.service;

import java.util.List;

import com.te.employee1.dto.Employee1;

public interface Employee1Service {
public Employee1 getEmployee(int empid);
	
	public boolean deleteEmployeeDetail(int empid);
	
	public List<Employee1> allEmployee();

}
