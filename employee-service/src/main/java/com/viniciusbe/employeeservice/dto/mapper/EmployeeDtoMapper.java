package com.viniciusbe.employeeservice.dto.mapper;

import com.viniciusbe.employeeservice.dto.EmployeeDto;
import com.viniciusbe.employeeservice.entity.Employee;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
public class EmployeeDtoMapper {

    public EmployeeDto mapToModel(Employee employee) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(employee, EmployeeDto.class);
    }
}
