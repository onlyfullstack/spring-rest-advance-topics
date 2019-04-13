package com.onlyfullstack.springasyncexample.service;

import java.util.List;

import com.onlyfullstack.springasyncexample.domainobject.EmployeeDO;
import com.onlyfullstack.springasyncexample.exception.EntityNotFoundException;

public interface EmployeeService {
	
	public void addEmployee(EmployeeDO employee);
	
	 public List<EmployeeDO> getAllEmployees();
	 
	 public EmployeeDO getEmployee(Long empId) throws EntityNotFoundException;

	public void deleteEmployee(Long employeeId) throws EntityNotFoundException;
}
