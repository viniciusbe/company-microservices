package com.viniciusbe.employeeservice.service.Impl;

import com.viniciusbe.employeeservice.dto.EmployeeDto;
import com.viniciusbe.employeeservice.entity.Employee;
import com.viniciusbe.employeeservice.exception.EmailAlreadyExistsException;
import com.viniciusbe.employeeservice.exception.ResourceNotFoundException;
import com.viniciusbe.employeeservice.mapper.EmployeeMapper;
import com.viniciusbe.employeeservice.repository.EmployeeRepository;
import com.viniciusbe.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Optional<Employee> matchingEmployee = employeeRepository.findByEmail(employeeDto.getEmail());

        if (matchingEmployee.isPresent()) {
            throw new EmailAlreadyExistsException(String.format("Email already exists : %s",employeeDto.getEmail()));
        }

        Employee employee = employeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = employeeMapper.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeByID(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );
        EmployeeDto employeeDto = employeeMapper.mapToEmployeeDto(employee);

        return employeeDto;
    }
}
