package com.viniciusbe.employeeservice.service.Impl;

import com.viniciusbe.employeeservice.dto.APIResponseDto;
import com.viniciusbe.employeeservice.dto.DepartmentDto;
import com.viniciusbe.employeeservice.dto.EmployeeDto;
import com.viniciusbe.employeeservice.entity.Employee;
import com.viniciusbe.employeeservice.exception.EmailAlreadyExistsException;
import com.viniciusbe.employeeservice.exception.ResourceNotFoundException;
import com.viniciusbe.employeeservice.mapper.EmployeeMapper;
import com.viniciusbe.employeeservice.repository.EmployeeRepository;
import com.viniciusbe.employeeservice.service.EmployeeService;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;
    private RestTemplate restTemplate;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Optional<Employee> matchingEmployee = employeeRepository.findByEmail(employeeDto.getEmail());

        if (matchingEmployee.isPresent()) {
            throw new EmailAlreadyExistsException(String.format("Email already exists : %s",employeeDto.getEmail()));
        }

        System.out.println(employeeDto);
        Employee employee = employeeMapper.mapToEmployee(employeeDto);
        System.out.println(employee);
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = employeeMapper.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeByID(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );

        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);

        DepartmentDto departmentDto = responseEntity.getBody();

        EmployeeDto employeeDto = employeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
