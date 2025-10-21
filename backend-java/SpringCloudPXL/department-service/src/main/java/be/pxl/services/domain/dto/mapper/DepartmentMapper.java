package be.pxl.services.domain.dto.mapper;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.dto.DepartmentRequest;
import be.pxl.services.domain.dto.DepartmentResponse;

import java.util.List;

public class DepartmentMapper {
    private DepartmentMapper() {}

    public static Department toEntity(DepartmentRequest request) {
        if (request == null) return null;
        return Department.builder()
                .organizationId(request.getOrganizationId())
                .name(request.getName())
                .position(request.getPosition())
                .build();
    }

    public static DepartmentResponse toResponse(Department department) {
        if (department == null) return null;
        return DepartmentResponse.builder()
                .id(department.getId())
                .organizationId(department.getOrganizationId())
                .name(department.getName())
                .position(department.getPosition())
                .employees(department.getEmployees() == null ? null : department.getEmployees())
                .build();
    }

    public static List<DepartmentResponse> toResponseList(List<Department> departments) {
        return departments == null ? List.of() : departments.stream().map(DepartmentMapper::toResponse).toList();
    }
}