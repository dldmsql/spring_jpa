package com.example.spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum AccidentType {
    CAR, DRIVER, BUILDING;

    @JsonCreator
    public static AccidentType from(String s) {
        return AccidentType.valueOf(s.toUpperCase());
    }
}
