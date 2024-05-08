package com.example.demo.domain.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public enum AuditStateEnum implements BaseEnum {

    PENDING("PENDING", "待审核"),
    APPROVED("APPROVED", "审核通过"),
    REJECTED("REJECTED", "审核不通过");

    private final String code;
    private final String name;

    AuditStateEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static AuditStateEnum create(@JsonProperty String code) {
        for (AuditStateEnum value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No element matches " + code);
    }

}
