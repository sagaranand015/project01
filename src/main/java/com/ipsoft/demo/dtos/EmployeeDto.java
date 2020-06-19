package com.ipsoft.demo.dtos;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class EmployeeDto {

    private String employeeId;

    private String employeeName;

    private String employeePhone;

    private String employeeEmail;

    private Timestamp createdOn;

    private Timestamp lastUpdatedOn;

}
