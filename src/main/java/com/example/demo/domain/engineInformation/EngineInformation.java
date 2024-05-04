package com.example.demo.domain.engineInformation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EngineInformation {
    private String engineModel;
    private String manufacturer;
    private String displacement;
    private String afterTreatment;
}
