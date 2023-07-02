package com.viniciusbe.organizationservice.service.impl;

import com.viniciusbe.organizationservice.dto.OrganizationDto;
import com.viniciusbe.organizationservice.entity.Organization;
import com.viniciusbe.organizationservice.mapper.OrganizationMapper;
import com.viniciusbe.organizationservice.repository.OrganizationRepository;
import com.viniciusbe.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);

        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
