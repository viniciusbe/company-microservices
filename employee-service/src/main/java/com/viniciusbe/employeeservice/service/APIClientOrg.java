package com.viniciusbe.employeeservice.service;

import com.viniciusbe.employeeservice.dto.DepartmentDto;
import com.viniciusbe.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE",path = "/api/organizations/")
public interface APIClientOrg {
    @GetMapping("{organization-code}")
    OrganizationDto getOrganization(@PathVariable("organization-code") String organizationCode);
}
