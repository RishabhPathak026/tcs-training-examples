package com.tcs.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Column(name = "student_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	@Column(name = "name")
	private String name;
	@Column(name = "rollno")
	private double rollno;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRollno() {
		return rollno;
	}
	public void setRollno(double rollno) {
		this.rollno = rollno;
	}
	
}
