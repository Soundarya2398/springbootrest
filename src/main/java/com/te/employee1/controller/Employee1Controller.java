package com.te.employee1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.employee1.dto.Employee1;
import com.te.employee1.service.Employee1Service;
@RestController
public class Employee1Controller {
	
	@Autowired
	private Employee1Service service;
	
	@GetMapping(path="/getdetails",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Employee1 empDetails(int empid) {
		return service.getEmployee(empid);
		
		
	}
	
	@GetMapping(path="/getEmp",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Employee1Response getempDetails(int empid) {
		Employee1Response response=new Employee1Response();
		boolean bean=service.deleteEmployeeDetail(empid);
		if(bean==true) {
			response.setStatus(200);
			response.setMsg("success");
			response.setDescription("data found for id"+empid);
			//response.setBean(bean)	;
			}else {
				response.setStatus(400);
				response.setMsg("failure");
				response.setDescription("something went wrong");
			}
		return response;
		
			}
	@GetMapping(path="/seeAll",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Employee1Response getAllEmpDetails() {
		Employee1Response response=new Employee1Response();
		 List<Employee1> list=service.allEmployee();
		 if(list!=null) {
			 response.setStatus(200);
			 response.setMsg("success");
			 response.setDescription("details are here"+list);
		 }else {
			 response.setStatus(400);
			 response.setMsg("failure");
			 response.setDescription("something went wrong");
			 
		 }
		return response;
		
	}
  

}
