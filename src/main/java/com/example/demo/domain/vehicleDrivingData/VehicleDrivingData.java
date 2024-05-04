package com.example.demo.domain.vehicleDrivingData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDrivingData {
    private String engineStatus;
    private String brakeStatus;
    private String tirePressure;
    private String mileageDriven;
    private String faultInformation;
    private String pedalUsage;
}
