package com.example.spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum AccidentStatus {
    COMPLETED, NONCOMPLETED;

    @JsonCreator
    public static AccidentStatus from(String s) {
        return AccidentStatus.valueOf(s.toUpperCase());
    }

}
