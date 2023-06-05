package com.viniciusbe.departmentservice.service.impl;

import com.viniciusbe.departmentservice.dto.DepartmentDto;
import com.viniciusbe.departmentservice.entity.Department;
import com.viniciusbe.departmentservice.mapper.DepartmentMapper;
import com.viniciusbe.departmentservice.repository.DepartmentRepository;
import com.viniciusbe.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private DepartmentMapper departmentMapper;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = departmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = departmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = departmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    }
}
