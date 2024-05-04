package com.example.demo.domain.enums;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import lombok.Getter;

@Getter
public enum UserTypeEnum implements BaseEnum {
    ADMIN("管理员"),
    VEHICLE_MANUFACTURER("车辆制造商"),
    VEHICLE_DEALER("汽车经销商"),
    VEHICLE_OWNER("车主用户");

    private final String name;

    UserTypeEnum(String name) {
        this.name = name;
    }
}
