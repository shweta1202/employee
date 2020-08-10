package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Employee repository.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
