package com.example.employee.dto;

/**
 * The type Employee dto.
 */
public class EmployeeDto {

    private int empId;
    private String empName;
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
