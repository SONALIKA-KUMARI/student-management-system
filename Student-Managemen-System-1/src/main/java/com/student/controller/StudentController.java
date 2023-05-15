package com.student.controller;
import com.student.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
 
	@GetMapping("/students/new")
	public String addnewStudent(Model m)
	{ 
		
		Student student=new Student();
		m.addAttribute("student", student);
		
		
        return "create_student";	
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student)
	{studentService.saveStudent(student);
		return "redirect:/students";
	}
	
  @GetMapping("/students/edit/{id}")
  public String editStudentForm(@PathVariable Long id, Model m)
  {
	  return "update";
  }
	
}
