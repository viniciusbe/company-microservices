package com.viniciusbe.employeeservice.service;

import com.viniciusbe.employeeservice.dto.APIResponseDto;
import com.viniciusbe.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeByID(Long employeeId);
}
