package com.example.employee.service;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.exception.BadRequestException;
import com.example.employee.exception.InternalServerErrorException;

import java.util.List;

public interface EmployeeService {

    void addOrUpdateEmployee(EmployeeDto employeeDto) throws InternalServerErrorException;
    List<EmployeeDto> getEmployees() throws InternalServerErrorException;
    void deleteEmployee(int empId) throws BadRequestException;
    EmployeeDto getEmployeeById(int empId) throws BadRequestException, InternalServerErrorException;
}
