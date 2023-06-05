package com.viniciusbe.departmentservice.mapper;


import com.viniciusbe.departmentservice.dto.DepartmentDto;
import com.viniciusbe.departmentservice.entity.Department;
import org.modelmapper.ModelMapper;

public class DepartmentMapper {
    private ModelMapper modelMapper;

    public DepartmentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DepartmentDto mapToDepartmentDto(Department department) {
//        return modelMapper.map(department, DepartmentDto.class);
        return AutoDepartmentMapper.INSTANCE.mapToDepartmentDto(department);
    }

    public Department mapToDepartment(DepartmentDto departmentDto) {
//        return modelMapper.map(departmentDto, Department.class);
        return AutoDepartmentMapper.INSTANCE.mapToDepartment(departmentDto);
    }
}
