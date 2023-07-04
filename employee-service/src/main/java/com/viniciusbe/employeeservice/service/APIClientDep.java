package com.viniciusbe.employeeservice.service;

import com.viniciusbe.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE",path = "/api/departments/")
public interface APIClientDep {
    @GetMapping("{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
}
