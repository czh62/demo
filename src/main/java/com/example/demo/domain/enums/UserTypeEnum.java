package com.example.demo.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public enum UserTypeEnum implements BaseEnum {
    ADMIN("ADMIN", "管理员"),
    VEHICLE_MANUFACTURER("VEHICLE_MANUFACTURER", "车辆制造商"),
    VEHICLE_DEALER("VEHICLE_DEALER", "汽车经销商"),
    VEHICLE_OWNER("VEHICLE_OWNER", "车主用户");

    private final String code;
    private final String name;

    UserTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static UserTypeEnum create(@JsonProperty String code) {
        for (UserTypeEnum value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No element matches " + code);
    }
}
