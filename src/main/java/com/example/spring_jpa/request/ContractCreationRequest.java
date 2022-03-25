package com.example.spring_jpa.request;

import lombok.Data;

@Data
public class ContractCreationRequest {
    // 계약 체결 시, 받아오는 정보
    private Long contractId;
    private Long insuranceId;
}
