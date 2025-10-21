package be.pxl.services.domain.dto;

import lombok.Data;

@Data
public class DepartmentRequest {
    private Long organizationId;
    private String name;
    private String position;
}