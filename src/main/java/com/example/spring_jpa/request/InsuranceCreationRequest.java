package com.example.spring_jpa.request;

import com.example.spring_jpa.entity.InsuranceType;
import lombok.Data;

@Data
public class InsuranceCreationRequest {
    private String name;
    private String content;
    private Long price;
    private Long due;
    private InsuranceType type;
    private Long employeeId;
}
