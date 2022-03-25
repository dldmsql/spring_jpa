package com.example.spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EmployeeDepart {
    SALES, DEVELOP, REWARD;

    @JsonCreator
    public static EmployeeDepart from(String s) {
        return EmployeeDepart.valueOf(s.toUpperCase());
    }
}
