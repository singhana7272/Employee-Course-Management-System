package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Course;

public interface CourseService {
	ArrayList<Course> showAllCourses() throws ClassNotFoundException, SQLException;
}
