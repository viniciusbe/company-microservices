package com.viniciusbe.departmentservice.service.impl;

import com.viniciusbe.departmentservice.dto.DepartmentDto;
import com.viniciusbe.departmentservice.dto.mapper.DepartmentDtoMapper;
import com.viniciusbe.departmentservice.entity.Department;
import com.viniciusbe.departmentservice.entity.mapper.DepartmentMapper;
import com.viniciusbe.departmentservice.repository.DepartmentRepository;
import com.viniciusbe.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = new DepartmentMapper().mapToModel(departmentDto);
        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = new DepartmentDtoMapper().mapToModel(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = new DepartmentDtoMapper().mapToModel(department);

        return departmentDto;
    }
}
