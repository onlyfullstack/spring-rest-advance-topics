package com.onlyfullstack.springasyncexample.repositoy;

import com.onlyfullstack.springasyncexample.domainobject.EmployeeDO;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeDO, Long> {

}
