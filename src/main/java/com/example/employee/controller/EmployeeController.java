package com.example.employee.controller;

import com.example.employee.constant.Constants;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.exception.BadRequestException;
import com.example.employee.exception.InternalServerErrorException;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/add")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeDto employeeDto)
            throws InternalServerErrorException {
        employeeService.addOrUpdateEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.OK).body(Constants.EMPLOYEE_DATA_ADDED);
    }

    @GetMapping(path = "/get")
    public ResponseEntity<List<EmployeeDto>> getEmployees() throws InternalServerErrorException {
        return new ResponseEntity(employeeService.getEmployees(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) throws BadRequestException{
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(Constants.EMPLOYEE_DATA_DELETED);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int id)
            throws BadRequestException,InternalServerErrorException {
        return new ResponseEntity(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDto employeeDto) throws
            InternalServerErrorException{
        employeeService.addOrUpdateEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.OK).body(Constants.EMPLOYEE_DATA_UPDATED);
    }
}