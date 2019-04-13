package com.onlyfullstack.springasyncexample.datatransferobject;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class EmployeeDTO {

	private Long id;
	
	@NotNull(message = "First name must not be empty")
	private String firstName;

	@NotNull(message = "Last name must not be empty")
	private String lastName;
	
	@Positive(message = "Salary must be positive")
	private Long salary;

	@Email(message="email must be valid")
	private String email;
}
