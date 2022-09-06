package com.htalssi.gestionemployes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htalssi.gestionemployes.model.Student;
import com.htalssi.gestionemployes.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:8080")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> listeStudents = studentService.findAllStudents();
		return new ResponseEntity<>(listeStudents, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long pId) {
		Student student = studentService.findStudentById(pId);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Student> addStudent(@RequestBody Student pStudent) {
		Student student = studentService.addStudent(pStudent);
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student pStudent) {
		Student student = studentService.addStudent(pStudent);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Student> deleteStudentById(@PathVariable("id") Long pId) {
		studentService.deleteStudent(pId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
