package com.example.demo.service;

import com.example.demo.domain.engineInformation.EngineInformation;
import com.example.demo.domain.menu.Menu;
import com.example.demo.domain.response.Response;
import com.example.demo.domain.vehicleDrivingData.VehicleDrivingData;
import com.example.demo.domain.vehicleFaultHistory.VehicleFaultHistory;
import com.example.demo.domain.vehicleInformation.VehicleInformation;
import com.example.demo.domain.vehicleTypeInformation.VehicleTypeInformation;

import java.util.List;

public interface VehicleService {

    Response<List<EngineInformation>> getEngineInformationList();
    Response<List<VehicleDrivingData>> getVehicleDrivingDataList();
    Response<List<VehicleFaultHistory>> getVehicleFaultList();
    Response<List<VehicleInformation>> getVehicleList();
    Response<List<VehicleTypeInformation>> getVehicleTypeList();
    Response<Boolean> permissionCheck(Menu menu);


}
