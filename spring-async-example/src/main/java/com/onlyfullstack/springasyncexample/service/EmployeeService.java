package com.onlyfullstack.springasyncexample.service;

import com.onlyfullstack.springasyncexample.domainobject.EmployeeDO;
import com.onlyfullstack.springasyncexample.exception.EntityNotFoundException;
import com.onlyfullstack.springasyncexample.repositoy.EmployeeRepository;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Log
public class EmployeeService {

  @Autowired
  private EmployeeRepository repository;

  public EmployeeDO addEmployee(EmployeeDO employee) {
    return repository.save(employee);
  }

  public EmployeeDO updateEmployee(EmployeeDO employee, Long employeeId) throws EntityNotFoundException {
    EmployeeDO employeeDO = repository.findById(employeeId).orElseThrow(()
            -> new EntityNotFoundException("Employee", "empId", employeeId.toString()));

    employeeDO.setEmail(employee.getEmail());
    employeeDO.setFirstName(employee.getFirstName());
    employeeDO.setLastName(employee.getLastName());
    employeeDO.setSalary(employee.getSalary());

    return repository.save(employeeDO);
  }

  public List<EmployeeDO> getAllEmployees() {
    return (List<EmployeeDO>) repository.findAll();
  }

  public EmployeeDO getEmployee(Long employeeId) throws EntityNotFoundException {
    return repository.findById(employeeId).orElseThrow(()
        -> new EntityNotFoundException("Employee", "empId", employeeId.toString()));
  }

  public void deleteEmployee(Long employeeId) throws EntityNotFoundException {
    EmployeeDO employee = repository.findById(employeeId).orElseThrow(()
        -> new EntityNotFoundException("Employee", "empId", employeeId.toString()));
    repository.delete(employee);
  }

  @Async
  public CompletableFuture<String> getCompletableFuture() {
    log.info("Entered inside processing huge data");
    try {
      log.info("Processing...");
      Thread.sleep(3000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    log.info("Exited from processing huge data");
    return CompletableFuture.completedFuture("hello");
  }
}
