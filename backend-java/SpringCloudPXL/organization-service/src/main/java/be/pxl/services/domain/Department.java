package be.pxl.services.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public class Department {
    private Long id;
    private Long organizationId;
    private String name;
    private String position;

    @Transient
    private List<Employee> employees;
}

