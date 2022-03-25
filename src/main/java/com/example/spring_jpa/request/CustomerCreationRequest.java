package com.example.spring_jpa.request;

import com.example.spring_jpa.entity.CustomerJob;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Data
public class CustomerCreationRequest {
    // 새로운 고객 등록 시, 받아오는 정보

    private String firstName;
    private String lastName;
    private CustomerJob job;

    // 고객 가입 날짜를 기록할 것인가?
}
