package com.htalssi.gestionemployes.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.htalssi.gestionemployes.exception.UserException;
import com.htalssi.gestionemployes.model.Employee;
import com.htalssi.gestionemployes.model.Student;
import com.htalssi.gestionemployes.repository.StudentRepository;
import com.htalssi.gestionemployes.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional 
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public Student addStudent(Student student) {
		student.setStudentCode(UUID.randomUUID().toString());
		return studentRepo.save(student);
	}

	@Override
	public List<Student> findAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public void deleteStudent(Long id) {
studentRepo.deleteById(id);		
	}

	@Override
	public Student findStudentById(Long id) {
		return studentRepo.findById(id).orElseThrow(() -> new UserException(" Student by id " + id + " was not found ") );
	}

}
