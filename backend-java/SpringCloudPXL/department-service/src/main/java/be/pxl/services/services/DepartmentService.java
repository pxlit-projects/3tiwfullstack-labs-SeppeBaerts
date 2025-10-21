package be.pxl.services.services;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;
import be.pxl.services.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department add(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> findByOrganization(Long organizationId) {
        return departmentRepository.findAll().stream()
                .filter(d -> organizationId.equals(d.getOrganizationId()))
                .toList();
    }

    @Override
    public List<Department> findByOrganizationWithEmployees(Long organizationId) {
        List<Employee> employees = List.of();
        return findByOrganization(organizationId).stream().peek(department -> {
            List<Employee> deptEmployees = List.of();
            department.setEmployees(deptEmployees);
        }).toList();
    }
}

