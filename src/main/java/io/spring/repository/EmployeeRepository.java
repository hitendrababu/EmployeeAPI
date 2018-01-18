package io.spring.repository;

import java.util.List;

import io.spring.entity.Employee;

public interface EmployeeRepository {
	
	List<Employee> findAll();
	
	Employee findOne(String id);
	
	Employee findbyEmail(String email);
	
	Employee create(Employee emp);
	
	Employee update(Employee emp);
	
	void delete(Employee emp);
	

}
