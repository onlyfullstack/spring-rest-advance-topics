package com.onlyfullstack.springasyncexample.service;

import com.onlyfullstack.springasyncexample.domainobject.EmployeeDO;
import com.onlyfullstack.springasyncexample.exception.EntityNotFoundException;
import com.onlyfullstack.springasyncexample.repositoy.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public void addEmployee(EmployeeDO employee) {
		repository.save(employee);
	}

	@Override
	public List<EmployeeDO> getAllEmployees() {
		return (List<EmployeeDO>) repository.findAll();
	}
	
	@Override
	public EmployeeDO getEmployee(Long employeeId) throws EntityNotFoundException {
		return repository.findById(employeeId).orElseThrow(() 
				-> new EntityNotFoundException("Employee", "empId", employeeId.toString()));
	}

	@Override
	public void deleteEmployee(Long employeeId) throws EntityNotFoundException {
		EmployeeDO employee = repository.findById(employeeId).orElseThrow(() 
				-> new EntityNotFoundException("Employee", "empId", employeeId.toString()));
		repository.delete(employee);
	}
}
