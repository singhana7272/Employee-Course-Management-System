package com.bean;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
public class Employee {
	
	private String empId;
	
	private String empName;
	
	private String empDesignation;
	
	private String empDepartment;
	
	private int empSalary;
}
