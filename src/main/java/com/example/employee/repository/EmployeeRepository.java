package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Employee repository.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
