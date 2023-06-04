package com.viniciusbe.employeeservice.mapper;

import com.viniciusbe.employeeservice.dto.EmployeeDto;
import com.viniciusbe.employeeservice.entity.Employee;
import org.modelmapper.ModelMapper;

public class EmployeeMapper {
    private ModelMapper modelMapper;

    public EmployeeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public EmployeeDto mapToEmployeeDto(Employee employee) {
//        return modelMapper.map(employee, EmployeeDto.class);
        return AutoEmployeeMapper.INSTANCE.mapToEmployeeDto(employee);
    }

    public Employee mapToEmployee(EmployeeDto employeeDto) {
//        return modelMapper.map(employeeDto, Employee.class);
        return AutoEmployeeMapper.INSTANCE.mapToEmployee(employeeDto);
    }
}
