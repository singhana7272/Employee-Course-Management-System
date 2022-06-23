package com.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bean.Course;
import com.bean.Employee;
import com.service.CourseService;
import com.service.CourseServiceImpl;
import com.service.EmployeeService;
import com.service.EmployeeServiceImpl;

@Component
public class EmployeePresentationImpl implements EmployeePresentation{
	
	@Autowired
	EmployeeService employeeService;
	
	public EmployeePresentationImpl(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	CourseService courseService=new CourseServiceImpl();
	
	@Override
	public void showMenu() {
		System.out.println("1.Show all courses");
		System.out.println("2.Register for course");
		System.out.println("3.Deregister for course");
		System.out.println("4.List All Participants for specific course");
		System.out.println("5.Exit");
	}

	@Override
	public void performMenu(int choice) {
		Scanner scanner=new Scanner(System.in);
		try{switch(choice) {
		case 1:
			ArrayList<Course> courses=null;
			courses = courseService.showAllCourses();
            for(Course course:courses) {
            	System.out.println(course);
            }		
		    break;
		case 2:
			System.out.println("Enter courseId for which you want to add employee");
			String courseId=scanner.nextLine();
			System.out.println("Enter id of the employee");
			String empId=scanner.nextLine();
	
			boolean status = employeeService.registerCourse(empId, courseId);
			if(status)
				System.out.println("Employee registered successfully");
			else
				System.out.println("Employee registration failed");
			break;
		case 3:
			System.out.println("Enter employee id");
			empId=scanner.nextLine();
			System.out.println("Enter course id");
			courseId=scanner.nextLine();
			status=employeeService.deregisterCourse(empId, courseId);
			
			if(status)
				System.out.println("Employee deregistered successfully");
			else
				System.out.println("Employee deregistration failed");
			break;
		case 4:
			System.out.println("Enter course id");
			courseId=scanner.nextLine();
			ArrayList<Employee> employees=null;
			employees=employeeService.showAllEmployeesForCourseId(courseId);
			for(Employee employee:employees) {
				System.out.println(employee);
			}
			break;
		case 5:
			System.out.println("Thanks for using Employee Management System");
			System.exit(0);
			break;
		}
		}catch(ClassNotFoundException|SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
