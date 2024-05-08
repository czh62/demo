package com.example.demo.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public enum EmissionStandardEnum implements BaseEnum {
    I("I", "国 I"),
    II("II", "国 II"),
    III("III", "国 III"),
    IV("IV", "国 IV"),
    V("V", "国 V"),
    VI("VI", "国 VI");


    private final String code;
    private final String name;

    EmissionStandardEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static EmissionStandardEnum create(@JsonProperty String code) {
        for (EmissionStandardEnum value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No element matches " + code);
    }

}
