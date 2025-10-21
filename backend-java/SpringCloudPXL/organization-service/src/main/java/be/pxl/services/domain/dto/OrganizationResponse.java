package be.pxl.services.domain.dto;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrganizationResponse {
    private Long id;
    private String name;
    private String address;
    private List<Employee> employees;
    private List<Department> departments;
}