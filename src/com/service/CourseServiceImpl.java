package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Course;
import com.persistence.CourseDao;
import com.persistence.CourseDaoImpl;
import com.persistence.EmployeeDao;
import com.persistence.EmployeeDaoImpl;

public class CourseServiceImpl implements CourseService {
	CourseDao courseDao=new CourseDaoImpl();
	
	@Override
	public ArrayList<Course> showAllCourses() throws ClassNotFoundException, SQLException {
		return courseDao.showAllCourses();
	}

}
