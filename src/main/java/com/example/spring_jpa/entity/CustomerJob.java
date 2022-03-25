package com.example.spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CustomerJob {
    STUDENT,
    OFFICER,
    DRIVER;

    @JsonCreator
    public static CustomerJob from(String s) {
        return CustomerJob.valueOf(s.toUpperCase());
    }

}
