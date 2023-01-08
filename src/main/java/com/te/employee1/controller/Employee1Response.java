package com.te.employee1.controller;

import com.te.employee1.dto.Employee1;

import lombok.Data;
@Data
public class Employee1Response {
	
	private int status;
	private String msg;
	private String description;
	
	private Employee1 bean;

}
