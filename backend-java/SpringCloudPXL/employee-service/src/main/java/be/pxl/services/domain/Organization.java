package be.pxl.services.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


public class Organization {


    private Long id;

    private String name;
    private String address;

    private List<Employee> employees;

    private List<Department> departments;
}

