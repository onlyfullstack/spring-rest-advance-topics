package com.onlyfullstack.springrestadvance.repositoy;

import org.springframework.data.repository.CrudRepository;

import com.onlyfullstack.springrestadvance.domainobject.EmployeeDO;

public interface EmployeeRepository extends CrudRepository<EmployeeDO, Long> {

}
