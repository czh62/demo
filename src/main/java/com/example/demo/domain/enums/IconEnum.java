package com.example.demo.domain.enums;


import lombok.Getter;

@Getter
public enum IconEnum implements BaseEnum {
    HomeFilled("HomeFilled"),
    UserFilled("UserFilled");


    private final String name;

    IconEnum(String name) {
        this.name = name;
    }

}
