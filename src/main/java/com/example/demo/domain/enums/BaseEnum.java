package com.example.demo.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public interface BaseEnum {

    @JsonValue
    String getName();

    String getCode();
}
