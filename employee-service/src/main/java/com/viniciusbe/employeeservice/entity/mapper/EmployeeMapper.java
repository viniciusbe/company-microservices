package com.viniciusbe.employeeservice.entity.mapper;

import com.viniciusbe.employeeservice.dto.EmployeeDto;
import com.viniciusbe.employeeservice.entity.Employee;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
public class EmployeeMapper {

    public Employee mapToModel(EmployeeDto employeeDto) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(employeeDto, Employee.class);
    }
}
