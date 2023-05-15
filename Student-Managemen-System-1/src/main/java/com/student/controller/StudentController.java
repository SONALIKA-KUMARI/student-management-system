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
	  m.addAttribute("student",studentService.getStudentById(id));
	  return "edit_student";
  }
  

  @PostMapping("/students/{id}")
  public String updateStudent( @PathVariable Long id ,@ModelAttribute("student") Student student, Model m )
  {   
	  Student existingStudent=studentService.getStudentById(id);
	  existingStudent.setId(id);
	  existingStudent.setFirstName(student.getFirstName());
	  existingStudent.setLastName(student.getLastName());
	  existingStudent.setEmail(student.getEmail());
 
    //save  update
	  studentService.updateStudent(existingStudent);
    return "redirect:/students";
  
  }
  
  
  @GetMapping("/students/{id}")
  public String deleteStudent(@PathVariable Long id)
  {  studentService.deleteStudentById(id);
     return  "redirect:/students";
  }
	
  
  
  
  
  
}
