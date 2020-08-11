package com.example.employee.controller;

import com.example.employee.constant.Constants;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.ResponseDto;
import com.example.employee.exception.BadRequestException;
import com.example.employee.exception.InternalServerErrorException;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Employee controller.
 */
@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Add employee response entity.
     *
     * @param employeeDto the employee dto
     * @return the response entity
     * @throws InternalServerErrorException the internal server error exception
     */
    @PostMapping(path = "/add")
    public ResponseEntity<ResponseDto> addEmployee(@RequestBody EmployeeDto employeeDto)
            throws InternalServerErrorException {
        final String id = employeeService.addOrUpdateEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(Constants.EMPLOYEE_DATA_ADDED, id));
    }

    /**
     * Gets employees.
     *
     * @return the employees
     * @throws InternalServerErrorException the internal server error exception
     */
    @GetMapping(path = "/fetchAll")
    public ResponseEntity<List<EmployeeDto>> getEmployees() throws InternalServerErrorException {
        return new ResponseEntity(employeeService.getEmployees(), HttpStatus.OK);
    }

    /**
     * Delete employee response entity.
     *
     * @param id the id
     * @return the response entity
     * @throws BadRequestException the bad request exception
     */
    @DeleteMapping(path = "/deleteById/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) throws BadRequestException {
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(Constants.EMPLOYEE_DATA_DELETED);
    }

    /**
     * Gets employee by id.
     *
     * @param id the id
     * @return the employee by id
     * @throws BadRequestException          the bad request exception
     * @throws InternalServerErrorException the internal server error exception
     */
    @GetMapping(path = "/fetchById/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int id)
            throws BadRequestException, InternalServerErrorException {
        return new ResponseEntity(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    /**
     * Update employee response entity.
     *
     * @param employeeDto the employee dto
     * @return the response entity
     * @throws InternalServerErrorException the internal server error exception
     */
    @PutMapping(path = "/update")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDto employeeDto) throws
            InternalServerErrorException {
        employeeService.addOrUpdateEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.OK).body(Constants.EMPLOYEE_DATA_UPDATED);
    }

}