package com.onlyfullstack.springasyncexample.domainobject;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "employee_data")
@SequenceGenerator(name="employee_id_seq", initialValue=5, allocationSize=100)
@Data
public class EmployeeDO {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_id_seq")
	private Long id;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	@Column(name="salary")
	private Long salary;

	@Column(name="email")
	private String email;
}
