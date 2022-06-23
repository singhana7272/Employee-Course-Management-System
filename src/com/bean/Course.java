package com.bean;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Course {
	
	private String courseId;
	
	private String courseName;
	
	private int courseFee;
	
	private boolean online;
	
	private boolean fulltime;

}
