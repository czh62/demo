package com.example.demo.domain.vehicleInformation;


import com.example.demo.domain.enums.AuditStateEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleInformation {
    private String carNumber;
    private AuditStateEnum auditState;
    private String vehicleIdentifyNumber;
    private String licensePlateColor;
}
