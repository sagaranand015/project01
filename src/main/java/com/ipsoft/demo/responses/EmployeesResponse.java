package com.ipsoft.demo.responses;

import com.ipsoft.demo.dtos.EmployeeDto;
import lombok.Data;

import java.util.List;

@Data
public class EmployeesResponse extends BaseResponse {

    private List<EmployeeDto> employees;

    private EmployeeDto employee;

    public EmployeesResponse(int status, String message) {
        super(status, message);
    }

    public EmployeesResponse(int status, String message, List<EmployeeDto> employees) {
        super(status, message);
        this.employees = employees;
    }

    public EmployeesResponse(int status, String message, EmployeeDto employee) {
        super(status, message);
        this.employee = employee;
    }
}
