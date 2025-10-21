package be.pxl.services.services;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;
import be.pxl.services.domain.Organization;
import be.pxl.services.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService implements IOrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    public Organization findById(Long id) {
        return organizationRepository.findById(id).orElse(null);
    }

    @Override
    public Organization findByIdWithDepartments(Long id) {
        Organization organization = findById(id);
        if (organization == null) return null;
        List<Department> departments = List.of();
        organization.setDepartments(departments);
        return organization;
    }

    @Override
    public Organization findByIdWithDepartmentsAndEmployees(Long id) {
        Organization organization = findByIdWithDepartments(id);
        if (organization == null) return null;
        List<Employee> employees = List.of();
        organization.setEmployees(employees);
        // fill employees within each department as well
        organization.getDepartments().forEach(dept -> {
            List<Employee> deptEmployees = List.of();
        });
        return organization;
    }

    @Override
    public Organization findByIdWithEmployees(Long id) {
        Organization organization = findById(id);
        if (organization == null) return null;
        List<Employee> employees = List.of();
        organization.setEmployees(employees);
        return organization;
    }
}

