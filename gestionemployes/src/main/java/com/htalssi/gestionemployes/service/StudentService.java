package com.htalssi.gestionemployes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htalssi.gestionemployes.model.Employee;
import com.htalssi.gestionemployes.model.Student;

@Service
public interface StudentService {

	public Student addStudent(Student student);
	
	public List<Student> findAllStudents();

	void deleteStudent(Long id);

	Student findStudentById(Long id);
}
