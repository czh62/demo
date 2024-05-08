package com.example.demo.domain.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public enum IconEnum implements BaseEnum {
    HomeFilled("HomeFilled", "HomeFilled");


    private final String code;
    private final String name;

    IconEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static IconEnum create(@JsonProperty String code) {
        for (IconEnum value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No element matches " + code);
    }
}
