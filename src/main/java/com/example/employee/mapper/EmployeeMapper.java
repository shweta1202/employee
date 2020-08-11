package com.example.employee.mapper;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * The interface Employee mapper.
 */
@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EmployeeMapper {

    /**
     * Entity to dto employee dto.
     *
     * @param employee the employee
     * @return the employee dto
     */
    EmployeeDto entityToDto(Employee employee);

    /**
     * Dto to entity employee.
     *
     * @param employeeDto the employee dto
     * @return the employee
     */
    Employee dtoToEntity(EmployeeDto employeeDto);

    /**
     * Entity to dto list list.
     *
     * @param employees the employees
     * @return the list
     */
    List<EmployeeDto> entityToDtoList(List<Employee> employees);

    /**
     * Dto to entity list list.
     *
     * @param employeeDto the employee dto
     * @return the list
     */
    List<Employee> dtoToEntityList(List<EmployeeDto> employeeDto);
}
