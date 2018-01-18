package io.spring.service;

import java.util.List;

import io.spring.entity.Employee;

public interface EmployeeService {

	
	List<Employee> findAll();
	
	Employee findOne(String id);
	
	Employee create(Employee emp);
	
	Employee update(Employee emp);
	
	void delete(String id);
	
}
