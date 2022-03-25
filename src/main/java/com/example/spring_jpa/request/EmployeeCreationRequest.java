package com.example.spring_jpa.request;

import com.example.spring_jpa.entity.EmployeeDepart;
import lombok.Data;

@Data
public class EmployeeCreationRequest {
    private Long pw;
    private String firstName;
    private String lastName;
    private EmployeeDepart employeeDepart;
}
