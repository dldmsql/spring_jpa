package com.example.spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Long pw;

    @Enumerated(EnumType.STRING)
    private EmployeeDepart employeeDepart; // 담당 부서

    @JsonBackReference
    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reward> rewards;

    @JsonBackReference
    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Insurance> insurances;

    @JsonBackReference
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Contract> contracts;
}
