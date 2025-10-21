package be.pxl.services.services;

import be.pxl.services.domain.Department;

import java.util.List;

public interface IDepartmentService {
    Department add(Department department);
    Department findById(Long id);
    List<Department> findAll();
    List<Department> findByOrganization(Long organizationId);
    List<Department> findByOrganizationWithEmployees(Long organizationId);
}

