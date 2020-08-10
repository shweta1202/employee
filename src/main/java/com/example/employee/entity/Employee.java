package com.example.employee.entity;

import com.example.employee.dto.EmployeeDto;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Employee.
 */
@Entity(name = "employee_data")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@empId", scope = EmployeeDto.class)
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//todo
    @Column(name = "emp_id")
    private int empId;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "designation")
    private String designation;

    /**
     * Gets emp id.
     *
     * @return the emp id
     */
    public int getEmpId() {
        return empId;
    }

    /**
     * Sets emp id.
     *
     * @param empId the emp id
     */
    public void setEmpId(int empId) {
        this.empId = empId;
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
