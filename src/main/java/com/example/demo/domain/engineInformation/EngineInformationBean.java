package com.example.demo.domain.engineInformation;

import lombok.Data;

import java.util.Date;

@Data
public class EngineInformationBean {
    private Integer id;
    private String engineModel;
    private String manufacturer;
    private String displacement;
    private String afterTreatment;
    private String createUser;
    private Date createTime;
    private String updateUser;
    private Date updateTime;
    private Boolean yn;
}
