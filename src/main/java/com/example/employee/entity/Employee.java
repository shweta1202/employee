package com.example.employee.entity;

import com.example.employee.dto.EmployeeDto;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * The type Employee.
 */
@Entity(name = "employee_data")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@empId", scope = EmployeeDto.class)
public class Employee implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "emp_id", nullable = false, unique = true)
    private String id;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "designation")
    private String designation;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets emp name.
     *
     * @return the emp name
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * Sets emp name.
     *
     * @param empName the emp name
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * Gets designation.
     *
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Sets designation.
     *
     * @param designation the designation
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
