package com.example.employee.service;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.exception.BadRequestException;
import com.example.employee.exception.InternalServerErrorException;

import java.util.List;

/**
 * The interface Employee service.
 */
public interface EmployeeService {

    /**
     * Add or update employee.
     *
     * @param employeeDto the employee dto
     * @throws InternalServerErrorException the internal server error exception
     */
    int addOrUpdateEmployee(EmployeeDto employeeDto) throws InternalServerErrorException;

    /**
     * Gets employees.
     *
     * @return the employees
     * @throws InternalServerErrorException the internal server error exception
     */
    List<EmployeeDto> getEmployees() throws InternalServerErrorException;

    /**
     * Delete employee.
     *
     * @param empId the emp id
     * @throws BadRequestException the bad request exception
     */
    void deleteEmployee(int empId) throws BadRequestException;

    /**
     * Gets employee by id.
     *
     * @param empId the emp id
     * @return the employee by id
     * @throws BadRequestException          the bad request exception
     * @throws InternalServerErrorException the internal server error exception
     */
    EmployeeDto getEmployeeById(int empId) throws BadRequestException, InternalServerErrorException;
}
