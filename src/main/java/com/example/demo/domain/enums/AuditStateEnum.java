package com.example.demo.domain.enums;


import lombok.Getter;

@Getter
public enum AuditStateEnum implements BaseEnum {

    PENDING("待审核"),
    APPROVED("审核通过"),
    REJECTED("审核不通过");

    private final String name;

    AuditStateEnum(String name) {
        this.name = name;
    }
}
