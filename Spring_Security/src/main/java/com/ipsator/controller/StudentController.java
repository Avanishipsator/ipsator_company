package com.ipsator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipsator.Entity.Student;
import com.ipsator.Service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService ss;

	@PostMapping("/Student")
	public ResponseEntity<Student> addStudent(Student s) {
		return new ResponseEntity<Student>(ss.addStudent(s), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/Student")
	public ResponseEntity<Student> getStudent(Integer id) {
		return new ResponseEntity<Student>(ss.getStudent(id), HttpStatus.ACCEPTED);
	}

}
