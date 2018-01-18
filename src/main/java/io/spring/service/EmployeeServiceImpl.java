package io.spring.service;

import java.util.Arrays;
//import java.lang.reflect.Array;
import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.spring.entity.Employee;
import io.spring.exception.BadRequestException;
import io.spring.exception.ResourceNotFoundException;
import io.spring.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		
		return repository.findAll();		
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findOne(String id) {
		Employee existingEmployee = repository.findOne(id);
		//Employee existingEmployee = null;
		if(existingEmployee == null) {
			//Exception Handling error code---> 404
			throw new ResourceNotFoundException("Employee with id "+id +"doesnt exist");
		}
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public Employee create(Employee emp) {
		Employee existingEmployee = repository.findbyEmail(emp.getEmail());
		if(existingEmployee != null) {
			//exception handling bad request---->400
			throw new BadRequestException("Employee with email "+emp.getEmail()+" already exist");
		}
		return repository.create(emp);
	}

	@Override
	@Transactional
	public Employee update(Employee emp) {
		Employee existingEmployee = repository.findOne(emp.getId());
		if(existingEmployee == null) {
			//exception handling 404
			throw new BadRequestException("Employee with id "+emp.getId() +"doesnt exist");
		}
		return repository.update( existingEmployee);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Employee existingEmployee = repository.findOne(id);
		if(existingEmployee == null) {
			//exception handling 404
			throw new BadRequestException("Employee with id "+id +"doesnt exist");
		}
		repository.delete(existingEmployee);
		
	}

}
