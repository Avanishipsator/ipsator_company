package com.ipsator.Service;

import java.util.List;

import com.ipsator.Entity.Student;

public interface StudentService {
	Student addStudent(Student st);

	List<Student> getAllStudent();

	Student getStudent(Integer id);

	void deleteStudent(Student st);

	Student updateStudent(Student st, Integer id);

}
