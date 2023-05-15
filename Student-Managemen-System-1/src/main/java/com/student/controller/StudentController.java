package com.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.student.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	} 
	
	//handler
	
	@GetMapping("/students")
	public String listStudents(Model m)
	{ m.addAttribute("students", studentService.getAllStudents());
		
	  return "students";
	}

}
