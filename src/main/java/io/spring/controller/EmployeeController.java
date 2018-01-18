package io.spring.controller;

//import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.spring.entity.Employee;
import io.spring.service.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@RequestMapping(method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Employee> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{id}",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Employee findOne(@PathVariable("id") String empId) {
		return service.findOne(empId);
	}
	
	@RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Employee create(@RequestBody Employee emp) {
		return service.create(emp);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}",
	        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
	        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Employee update(@PathVariable("id") String empId, @RequestBody Employee emp) {
		return service.update(emp);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable("id") String empId) {
		service.delete(empId);
	}

}
