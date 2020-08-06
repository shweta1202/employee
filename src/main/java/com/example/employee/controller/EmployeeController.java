package com.example.employee.controller;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.ResponseMessageDto;
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
    public ResponseEntity<ResponseMessageDto> addEmployee(@RequestBody EmployeeDto employeeDto)
            throws InternalServerErrorException {
        employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(new ResponseMessageDto("Employee Added"),HttpStatus.OK);
    }

    @GetMapping(path = "/get")
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        return new ResponseEntity(employeeService.getEmployees(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ResponseMessageDto> deleteEmployee(@PathVariable int id) throws BadRequestException{
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(new ResponseMessageDto("Employee Deleted"), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int id)
            throws BadRequestException,InternalServerErrorException {
        return new ResponseEntity(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<ResponseMessageDto> updateEmployee(@PathVariable int id, @RequestBody EmployeeDto employeeDto) throws
            BadRequestException, InternalServerErrorException{
        employeeService.updateEmployeeById(id, employeeDto.getEmpName());
        return new ResponseEntity<>(new ResponseMessageDto("Employee data Updated"),HttpStatus.OK);
    }
}
