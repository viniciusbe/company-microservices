package com.viniciusbe.departmentservice.entity.mapper;

import com.viniciusbe.departmentservice.dto.DepartmentDto;
import com.viniciusbe.departmentservice.entity.Department;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
public class DepartmentMapper {

    public Department mapToModel(DepartmentDto departmentDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(departmentDto, Department.class);
    }

}
