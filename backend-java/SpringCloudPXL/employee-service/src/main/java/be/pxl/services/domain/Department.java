package be.pxl.services.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

public class Department {


    private Long id;

    private Long organizationId;
    private String name;
    private String position;

    private List<Employee> employees;
}

