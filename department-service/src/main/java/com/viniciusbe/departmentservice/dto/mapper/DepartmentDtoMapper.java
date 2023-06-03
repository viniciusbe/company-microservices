package com.viniciusbe.departmentservice.dto.mapper;

import com.viniciusbe.departmentservice.dto.DepartmentDto;
import com.viniciusbe.departmentservice.entity.Department;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
public class DepartmentDtoMapper {

    public DepartmentDto mapToModel(Department department) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(department, DepartmentDto.class);
    }

}
