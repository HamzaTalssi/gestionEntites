package com.htalssi.gestionemployes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.htalssi.gestionemployes.model.Employee;
import com.htalssi.gestionemployes.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:8080")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> listeEmployes = employeeService.findAllEmployees();
		return new ResponseEntity<>(listeEmployes, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long pId) {
		Employee employee = employeeService.findEmployeeById(pId);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee pEmployee) {
		Employee employee = employeeService.addEmployee(pEmployee);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee pEmployee) {
		Employee employee = employeeService.addEmployee(pEmployee);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable("id") Long pId) {
		employeeService.deleteEmployee(pId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
