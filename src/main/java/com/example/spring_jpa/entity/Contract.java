package com.example.spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startOn;
    private LocalDate dueOn;

    @ManyToOne
    @JoinColumn(name = "insurance_id")
    @JsonManagedReference
    private Insurance insurance;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonManagedReference
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonManagedReference
    private Employee employee;

    @JsonBackReference
    @OneToOne(mappedBy = "contract", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Reward reward;
}
