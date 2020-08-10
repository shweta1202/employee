package com.example.employee.service.impl;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;
import com.example.employee.exception.BadRequestException;
import com.example.employee.exception.InternalServerErrorException;
import com.example.employee.mapper.EmployeeMapper;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

/**
 * The type Employee service.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void addOrUpdateEmployee(@RequestBody EmployeeDto employeeDto) throws InternalServerErrorException {
        try {
            employeeRepository.save(employeeMapper.dtoToEntity(employeeDto));
        } catch (Exception e) {
            throw new InternalServerErrorException("Employee couldn't be added");
        }
    }

    @Override
    public List<EmployeeDto> getEmployees() throws InternalServerErrorException{
        try {
            return employeeMapper.entityToDtoList((List<Employee>) employeeRepository.findAll());
        } catch (Exception e) {
            throw new InternalServerErrorException("Couldn't get Employees");
        }
    }

    @Override
    public void deleteEmployee(int empId) throws BadRequestException {
        try{
            employeeRepository.deleteById(empId);
        } catch (Exception e) {
            throw new BadRequestException("Couldn't find Employee with id: " + empId);
        }

    }

    @Override
    public EmployeeDto getEmployeeById(int empId) throws BadRequestException, InternalServerErrorException {
        Optional<Employee> employee;
        try {
            employee = employeeRepository.findById(empId);
        } catch (Exception e) {
            throw new InternalServerErrorException();
        }
        if(employee.isPresent()){
            return employeeMapper.entityToDto(employee.get());
        }
        throw new BadRequestException("Couldn't find employee with id: "+ empId);
    }
}
