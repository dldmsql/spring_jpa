package com.example.spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum InsurancePermitted {
    nonapprove, approve;

    @JsonCreator
    public static InsurancePermitted from(String s) {
        return InsurancePermitted.valueOf(s.toUpperCase());
    }
}
