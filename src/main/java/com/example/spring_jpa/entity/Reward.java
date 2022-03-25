package com.example.spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "reward")
public class Reward {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String reason;
    private Long price;
    private LocalDate date;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "accident_id")
    private Accident accident;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
}
