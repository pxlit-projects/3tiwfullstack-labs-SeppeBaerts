package be.pxl.services.domain.dto.mapper;

import be.pxl.services.domain.Organization;
import be.pxl.services.domain.dto.OrganizationRequest;
import be.pxl.services.domain.dto.OrganizationResponse;

import java.util.List;

public class OrganizationMapper {
    private OrganizationMapper() {}

    public static Organization toEntity(OrganizationRequest request) {
        if (request == null) return null;
        return Organization.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }

    public static OrganizationResponse toResponse(Organization organization) {
        if (organization == null) return null;
        return OrganizationResponse.builder()
                .id(organization.getId())
                .name(organization.getName())
                .address(organization.getAddress())
                .employees(organization.getEmployees() == null ? null : organization.getEmployees())
                .departments(organization.getDepartments() == null ? null : organization.getDepartments())
                .build();
    }

    public static List<OrganizationResponse> toResponseList(List<Organization> organizations) {
        return organizations == null ? List.of() : organizations.stream().map(OrganizationMapper::toResponse).toList();
    }
}