package com.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.beans.Student;
import com.tcs.dao.StudentRepository;
import com.tcs.exceptions.StudentNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository dao;
	
	@Override
	@Transactional
	public Student store(Student student) {
		// save method return type changes according to the Entity name you have mapped
		return dao.save(student);
	}

	@Override
	public Student fetchStudentById(int studentId) throws StudentNotFoundException {
		Student p = dao.findById(studentId).orElse(null);
		if(p == null) {
			throw new StudentNotFoundException("Student with an id "+studentId+" not found");
		}
		return p;
	}

	@Override
	@Transactional
	public void deleteStudentById(int studentId) throws StudentNotFoundException {
		Student p = fetchStudentById(studentId);
		dao.delete(p);
	}

	@Override
	@Transactional
	public Student updateStudentRollno(int studentId, double rollno) throws StudentNotFoundException {
		Student p = fetchStudentById(studentId);
		p.setRollno(rollno);
		return p;
	}

	@Override
	public List<Student> fetchStudents() {
		return dao.findAll();
	}

}
