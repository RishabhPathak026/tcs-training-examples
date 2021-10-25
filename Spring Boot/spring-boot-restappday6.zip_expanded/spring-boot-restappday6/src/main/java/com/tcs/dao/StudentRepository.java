package com.tcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.beans.Student;
/*
 * You can call methods like save(object), findAll(), findById()
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
