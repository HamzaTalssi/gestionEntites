package com.htalssi.gestionemployes.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.htalssi.gestionemployes.exception.UserException;
import com.htalssi.gestionemployes.model.Employee;
import com.htalssi.gestionemployes.repository.EmployeeRepository;
import com.htalssi.gestionemployes.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional 
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}

	@Override
	public Employee findEmployeeById(Long id) {
		return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserException(" Employee by id " + id + " was not found "));
	}
}
