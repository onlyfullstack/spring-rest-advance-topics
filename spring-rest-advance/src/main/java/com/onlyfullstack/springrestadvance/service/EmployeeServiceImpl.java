package com.onlyfullstack.springrestadvance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlyfullstack.springrestadvance.domainobject.EmployeeDO;
import com.onlyfullstack.springrestadvance.exception.EntityNotFoundException;
import com.onlyfullstack.springrestadvance.repositoy.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public void addEmployee(EmployeeDO employee) {
		repository.save(employee);
	}

	public List<EmployeeDO> getAllEmployees() {
		return (List<EmployeeDO>) repository.findAll();
	}
	
	public EmployeeDO getEmployee(Long employeeId) throws EntityNotFoundException{
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
