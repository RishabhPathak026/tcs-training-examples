package com.tcs.service;

import java.util.List;

import com.tcs.beans.Student;
import com.tcs.exceptions.StudentNotFoundException;

public interface StudentService {
	public Student store(Student student);
	public Student fetchStudentById(int studentId) throws StudentNotFoundException;
	public void deleteStudentById(int studentId) throws StudentNotFoundException;
	public Student updateStudentRollno(int studentId, double rollno)  throws StudentNotFoundException;
	public List<Student> fetchStudents();
}
