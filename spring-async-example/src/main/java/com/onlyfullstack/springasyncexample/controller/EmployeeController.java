package com.onlyfullstack.springasyncexample.controller;

import com.onlyfullstack.springasyncexample.datatransferobject.EmployeeDTO;
import com.onlyfullstack.springasyncexample.domainobject.EmployeeDO;
import com.onlyfullstack.springasyncexample.exception.EntityNotFoundException;
import com.onlyfullstack.springasyncexample.service.EmailService;
import com.onlyfullstack.springasyncexample.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ModelMapper mapper;

	 @GetMapping
	  public List<EmployeeDTO> getAllEmployees() {
		 List<EmployeeDO> employeeDOList = service.getAllEmployees();
		 List<EmployeeDTO> employeeDTOList = employeeDOList.stream()
				 .map(employee -> mapper.map(employee, EmployeeDTO.class))
				 .collect(Collectors.toList());
		 
		 return employeeDTOList;
	  }
	 
	 @GetMapping(value="{employeeId}")
	  public EmployeeDO getEmployee(@PathVariable(name="employeeId") Long empId ) throws EntityNotFoundException {
	   return service.getEmployee(empId);
	  }
	 
	 @PostMapping
	 public ResponseEntity<Object> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		 System.out.println("Entered in addEmployee with : "+employeeDTO);
		 EmployeeDO employeeDO = mapper.map(employeeDTO, EmployeeDO.class);
		 service.addEmployee(employeeDO);
		 System.out.println("Employee saved into database");
		 emailService.sendMail(employeeDO.getEmail());
		 System.out.println("Exited from addEmployee");
		 return new ResponseEntity<>(HttpStatus.CREATED);
	 }
	 
    @DeleteMapping
    public void deleteEmployee(@PathVariable Long employeeId) throws EntityNotFoundException
    {
    	service.deleteEmployee(employeeId);
    }
}
