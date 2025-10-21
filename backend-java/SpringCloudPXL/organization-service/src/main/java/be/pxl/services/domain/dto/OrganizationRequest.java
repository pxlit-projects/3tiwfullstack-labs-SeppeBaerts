package be.pxl.services.domain.dto;

import lombok.Data;

@Data
public class OrganizationRequest {
    private String name;
    private String address;
}