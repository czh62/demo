package com.example.demo.domain.vehicleFaultHistory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleFaultHistory {
    private String carNumber;
    private String terminalNumber;
    private String date;
    private String obdProtocol;
    private String vehicleIdentificationNumber;
    private String totalFaultCode;
    private String validFaultCodeList;
}
