package com.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bean.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	private static final String url="jdbc:mysql://localhost:3306/employeecoursedb";
	private static final String user="root";
	private static final String password="admin";
	
	@Override
	public boolean registerCourse(String empId, String courseId) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url,user,password);
		String query="insert into registrations(empId,course_id) values (?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1, empId);
		preparedStatement.setString(2, courseId);
		
		int row=preparedStatement.executeUpdate();
		
		connection.close();
		
		if(row>0)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean deregisterCourse(String empId, String courseId) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url,user,password);
		String query="delete from registrations where empId=? and course_id=?";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1, empId);
		preparedStatement.setString(2, courseId);
		
		int row=preparedStatement.executeUpdate();
		connection.close();
		if(row==1)
			return true;
		else
			return false;
	}
	
	@Override
	public ArrayList<Employee> ShowAllEmployeesForCourseId(String courseId) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url,user,password);
		String query="select e.* from registrations r JOIN employees e ON r.empId=e.empId where course_id=?";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1, courseId);
		ResultSet resultSet=preparedStatement.executeQuery();
		ArrayList<Employee> employees=new ArrayList<>();
		while(resultSet.next()) {
			String empId=resultSet.getString("empId");
			String empName=resultSet.getString("empName");
			String department=resultSet.getString("department");
			String designation=resultSet.getString("designation");
			int salary=resultSet.getInt("salary");
			
			Employee employee=new Employee(empId,empName,department,designation,salary);
			employees.add(employee);
		}
		connection.close();
		return employees;
	}
	
	
}
