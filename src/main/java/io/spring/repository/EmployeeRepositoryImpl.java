package io.spring.repository;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.spring.entity.Employee;
import io.spring.exception.BadRequestException;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Employee> findAll() {
		
		TypedQuery<Employee> query = em.createNamedQuery("Employee.findAll", Employee.class);
		
		//query.setParameter("paramEmail", "vnarla@uncc.edu");
		
		List<Employee> resultList = query.getResultList();
		return resultList;
		
	}

	@Override
	public Employee findOne(String id) {
		
		return em.find(Employee.class, id);
	}

	@Override
	public Employee create(Employee emp) {
		em.persist(emp);
		return emp;
	}

	@Override
	public Employee update(Employee emp) {
		//TypedQuery<Employee> query = em.,
		return em.merge(emp);
	}

	public void delete(Employee emp) {
		// TODO Auto-generated method stub
		em.remove(emp);
		
	}

	@Override
	public Employee findbyEmail(String email) {
		
		TypedQuery<Employee> query = em.createNamedQuery("Employee.findByEmail", Employee.class);
		
		query.setParameter("paramEmail", email);
		
		List<Employee> resultList = query.getResultList();
		
		//return query.getSingleResult();
		if(resultList != null && resultList.size() == 1) {
			return resultList.get(0);
		}
		else {
			return null;
			
		}
		
	}

}
