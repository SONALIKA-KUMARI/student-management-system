package com.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.student.repository.StudentRepository;
import com.student.entity.Student;


@SpringBootApplication
public class StudentManagemenSystem1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagemenSystem1Application.class, args);
		System.out.println("sonalika it running");

	
	}
	 
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
//		Student  s1 =new Student (1,"sonalika","kumari","sona@gmail.com");
//		studentRepository.save(s1);
//		Student  s2 =new Student (2,"mona","kumari","mona@gmail.com");
//		studentRepository.save(s2);
	}

}
