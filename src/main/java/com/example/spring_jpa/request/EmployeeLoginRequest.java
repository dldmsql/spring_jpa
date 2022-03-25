package com.example.spring_jpa.request;

import lombok.Data;

@Data
public class EmployeeLoginRequest {
    private Long id;
    private Long pw;
}
