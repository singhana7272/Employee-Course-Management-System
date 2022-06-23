package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.persistence.EmployeeDao;
import com.persistence.EmployeeDaoImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
	this.employeeDao=employeeDao;
	}
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public boolean registerCourse(String empId, String courseId) throws ClassNotFoundException, SQLException {
		return employeeDao.registerCourse(empId, courseId);
	}

	@Override
	public boolean deregisterCourse(String empId, String courseId) throws ClassNotFoundException, SQLException {
		return employeeDao.deregisterCourse(empId, courseId);
	}

	@Override
	public ArrayList<Employee> showAllEmployeesForCourseId(String courseId) throws ClassNotFoundException, SQLException {
		return employeeDao.ShowAllEmployeesForCourseId(courseId);
	}

}
