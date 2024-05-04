package com.example.demo.domain.vehicleTypeInformation;

import com.example.demo.domain.enums.AuditStateEnum;
import com.example.demo.domain.enums.EmissionStandardEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleTypeInformation {
    private String vehicleModel;
    private String engineModel;
    private EmissionStandardEnum emissionStandard;
    private AuditStateEnum auditState;
    private String manufacturer;
    private String brand;
}
