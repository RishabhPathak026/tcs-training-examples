package com.tcs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.beans.CustomResponse;
import com.tcs.beans.Student;
import com.tcs.exceptions.StudentNotFoundException;
import com.tcs.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentRest {

	@Autowired
	private StudentService service;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveStudent(@RequestBody Student student) {
		ResponseEntity<Object> response = 
				ResponseEntity.status(HttpStatus.CREATED).body(service.store(student));
		return response;
	}
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getStudents() {
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchStudents());
	}
	// student/1, student/2, student/3
	@GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findStudent(@PathVariable("id") int studentId) {
		ResponseEntity<Object> response = null;
		try {
			Student student = service.fetchStudentById(studentId);
			response = ResponseEntity.status(HttpStatus.OK).body(student);
		} catch(StudentNotFoundException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		return response;
	}
	// student/1/15000
	@PutMapping(path = "{id}/{rollno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateStudentRollno(@PathVariable("id") int id, @PathVariable("rollno") double rollno) {
		ResponseEntity<Object> response = null;
		try {
			Student student = service.updateStudentRollno(id, rollno);
			response = ResponseEntity.status(HttpStatus.OK).body(student);
		} catch(StudentNotFoundException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		return response;
	}
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Object> deleteStudent(@PathVariable("id") int id) {
		ResponseEntity<Object> response = null;
		try {
			service.deleteStudentById(id);
			CustomResponse data = new CustomResponse();
			data.setMsg("Student with an id "+id+" deleted");
			response = ResponseEntity.status(HttpStatus.OK).body(data);
		} catch(StudentNotFoundException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		return response;
	}
}
