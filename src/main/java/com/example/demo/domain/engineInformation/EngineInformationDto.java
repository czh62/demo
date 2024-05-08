package com.example.demo.domain.engineInformation;

import lombok.Data;

import java.util.Date;

@Data
public class EngineInformationDto {
    private Integer id;
    private String engineModel;
    private String manufacturer;
    private String displacement;
    private String afterTreatment;
    private Integer count;
}
