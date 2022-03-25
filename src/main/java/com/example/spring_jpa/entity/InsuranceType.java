package com.example.spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum InsuranceType {
    CAR, DRIVER, BUILDING;

    @JsonCreator
    public static InsuranceType from(String s) {
        return InsuranceType.valueOf(s.toUpperCase());
    }
}
