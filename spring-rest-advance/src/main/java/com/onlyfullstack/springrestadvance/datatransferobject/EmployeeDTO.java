package com.onlyfullstack.springrestadvance.datatransferobject;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class EmployeeDTO {

	private Long id;
	
	@NotNull(message = "First name must not be empty")
	private String firstName;

	@NotNull(message = "Last name must not be empty")
	private String lastName;
	
	@Positive(message = "Salary must be positive")
	private Long salary;

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}
}
