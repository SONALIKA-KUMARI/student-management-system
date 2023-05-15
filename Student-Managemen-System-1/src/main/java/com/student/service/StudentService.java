package com.student.service;

import java.util.List;

import com.student.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	Student saveStudent(Student student);
}
