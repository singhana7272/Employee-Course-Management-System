package com.client;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.presentation.EmployeePresentation;
import com.presentation.EmployeePresentationImpl;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext springContainer=new ClassPathXmlApplicationContext("empCourse.xml");
		EmployeePresentation employeePresentation=(EmployeePresentation)springContainer.getBean("employeePresentationImpl");
		
		Scanner scanner=new Scanner(System.in);
		
		while(true) {
			employeePresentation.showMenu();
			System.out.println("Enter your choice");
			int ch=scanner.nextInt();
			employeePresentation.performMenu(ch);
		}
	}

}
