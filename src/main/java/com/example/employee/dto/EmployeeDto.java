package com.example.employee.dto;

/**
 * The type Employee dto.
 */
public class EmployeeDto {

    private String id;
    private String empName;
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
