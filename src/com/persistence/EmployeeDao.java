package com.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Course;
import com.bean.Employee;

public interface EmployeeDao {
	boolean registerCourse(String empId,String courseId) throws ClassNotFoundException, SQLException;
	boolean deregisterCourse(String empId,String courseId) throws ClassNotFoundException, SQLException;
	ArrayList<Employee> ShowAllEmployeesForCourseId(String courseId) throws ClassNotFoundException, SQLException;
}
