package com.viniciusbe.employeeservice.service.Impl;

import com.viniciusbe.employeeservice.dto.EmployeeDto;
import com.viniciusbe.employeeservice.dto.mapper.EmployeeDtoMapper;
import com.viniciusbe.employeeservice.entity.Employee;
import com.viniciusbe.employeeservice.entity.mapper.EmployeeMapper;
import com.viniciusbe.employeeservice.repository.EmployeeRepository;
import com.viniciusbe.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new EmployeeMapper().mapToModel(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = new EmployeeDtoMapper().mapToModel(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeByID(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        EmployeeDto employeeDto = new EmployeeDtoMapper().mapToModel(employee);

        return employeeDto;
    }
}
