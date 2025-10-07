package be.pxl.services.services;

import be.pxl.services.domain.Employee;
import be.pxl.services.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findByDepartment(Long departmentId) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .toList();
    }

    @Override
    public List<Employee> findByOrganization(Long organizationId) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getOrganizationId().equals(organizationId))
                .toList();
    }
}
