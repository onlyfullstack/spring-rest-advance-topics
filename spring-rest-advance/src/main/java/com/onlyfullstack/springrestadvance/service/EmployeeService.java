package com.onlyfullstack.springrestadvance.service;

import java.util.List;

import com.onlyfullstack.springrestadvance.domainobject.EmployeeDO;
import com.onlyfullstack.springrestadvance.exception.EntityNotFoundException;

public interface EmployeeService {
	
	public void addEmployee(EmployeeDO employee);
	
	 public List<EmployeeDO> getAllEmployees();
	 
	 public EmployeeDO getEmployee(Long empId) throws EntityNotFoundException;

	public void deleteEmployee(Long employeeId) throws EntityNotFoundException;
}
