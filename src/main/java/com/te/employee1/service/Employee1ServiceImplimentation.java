package com.te.employee1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.employee1.dao.Employee1Dao;
import com.te.employee1.dto.Employee1;
@Service
public class Employee1ServiceImplimentation implements Employee1Service {
	@Autowired
	private Employee1Dao dao;
		@Override
		public Employee1 getEmployee(int empid) {
			if (empid > 0)
				return dao.getEmployee(empid);

			return null;
		}
		@Override
		public boolean deleteEmployeeDetail(int empid) {
			if (empid > 0) {
				return dao.deleteEmployeeDetail(empid);
			}
			return false;
		}
		@Override
		public List<Employee1> allEmployee() {
			
			return dao.allEmployee();
		}


}
