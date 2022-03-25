package com.example.spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // 보험명
    private String content; // 보장 내용
    private Long due; // 보장 기간
    private Long price; // 보장 금액
    @Enumerated(EnumType.ORDINAL)
    private InsurancePermitted insurancePermitted;
    @Enumerated(EnumType.STRING)
    private InsuranceType type; // 보험 유형

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "emplyee_id")
    private Employee employee;

    @JsonBackReference
    @OneToMany(mappedBy = "insurance", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Contract> contracts;
}
