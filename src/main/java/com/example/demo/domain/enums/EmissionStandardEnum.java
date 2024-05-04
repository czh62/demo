package com.example.demo.domain.enums;

import lombok.Getter;

@Getter
public enum EmissionStandardEnum implements BaseEnum {
    I("国 I"),
    II("国 II"),
    III("国 III"),
    IV("国 IV"),
    V("国 V"),
    VI("国 VI");


    private final String name;

    EmissionStandardEnum(String name) {
        this.name = name;
    }

}
