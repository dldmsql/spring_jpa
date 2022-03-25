package com.example.spring_jpa.request;

import lombok.Data;

@Data
public class RewardRequest {
    private Long employeeId;
    private Long price;
    private String reason;
    private Long accidentId;
    private Long contractId;
}
