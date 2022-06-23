package com.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Course;

public interface CourseDao {
	ArrayList<Course> showAllCourses() throws SQLException, ClassNotFoundException;
}
