package be.pxl.services.domain.dto;

import be.pxl.services.domain.Employee;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DepartmentResponse {
    private Long id;
    private Long organizationId;
    private String name;
    private String position;
    private List<Employee> employees;
}