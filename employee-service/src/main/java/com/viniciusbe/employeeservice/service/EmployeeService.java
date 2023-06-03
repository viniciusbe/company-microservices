package com.viniciusbe.employeeservice.service;

import com.viniciusbe.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeByID(Long employeeId);
}
