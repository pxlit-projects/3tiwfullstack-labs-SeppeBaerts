package be.pxl.services.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public class Organization {

    private Long id;

    private String name;
    private String address;

    private List<Employee> employees;

    private List<Department> departments;
}

