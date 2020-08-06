package com.example.employee.mapper;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR )
public interface EmployeeMapper {

    EmployeeDto entityToDto(Employee employee);
    Employee dtoToEntity(EmployeeDto employeeDto);
    List<EmployeeDto> entityToDtoList(List<Employee> employees);
}
