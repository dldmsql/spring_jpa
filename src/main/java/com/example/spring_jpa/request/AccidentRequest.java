package com.example.spring_jpa.request;

import com.example.spring_jpa.entity.AccidentType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AccidentRequest {
    private Long customerId;
    private LocalDate accidentDate;
    private String accidentPlace;
    private AccidentType accidentType;
}
