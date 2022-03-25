package com.example.spring_jpa.request;

import com.example.spring_jpa.entity.InsuranceType;
import lombok.Data;

@Data
public class InsuranceReadsRequest {
    private InsuranceType type; // 보험 유형
    private Long customerId; // 고객 아이디

} 
