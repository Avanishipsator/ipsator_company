package com.ipsator.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipsator.Entity.Student;
import com.ipsator.Repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo sr;

	@Override
	public Student addStudent(Student st) {
		// TODO Auto-generated method stub
		
		return  sr.save(st);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public Student getStudent(Integer id) {
		// TODO Auto-generated method stub
		Optional<Student> s = sr.findById(id);
		if (s.isPresent()) {
			return s.get();
		}
		return null;
	}

	@Override
	public void deleteStudent(Student st) {
		// TODO Auto-generated method stub
		sr.delete(st);

	}

	@Override
	public Student updateStudent(Student st, Integer id) {
		// TODO Auto-generated method stub
		Optional<Student> s = sr.findById(id);
		if (s.isPresent()) {
			Student ss = s.get();
			ss.setCourse(st.getCourse());
			ss.setName(st.getName());
			return sr.save(ss);

		}
		return null;
	}

}
