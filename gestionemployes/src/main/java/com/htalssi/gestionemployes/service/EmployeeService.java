package com.htalssi.gestionemployes.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.htalssi.gestionemployes.model.Employee;


@Service
public interface EmployeeService {

	public Employee addEmployee(Employee employee);
	
	public List<Employee> findAllEmployees();

	void deleteEmployee(Long id);

	Employee findEmployeeById(Long id);
}
