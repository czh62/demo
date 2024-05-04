package com.example.demo.service.impl;

import com.example.demo.domain.engineInformation.EngineInformation;
import com.example.demo.domain.menu.Menu;
import com.example.demo.domain.response.Response;
import com.example.demo.domain.user.UserBean;
import com.example.demo.domain.vehicleDrivingData.VehicleDrivingData;
import com.example.demo.domain.vehicleFaultHistory.VehicleFaultHistory;
import com.example.demo.domain.vehicleInformation.VehicleInformation;
import com.example.demo.domain.vehicleTypeInformation.VehicleTypeInformation;
import com.example.demo.service.UserService;
import com.example.demo.service.VehicleService;
import jakarta.annotation.Resource;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.SystemConst.*;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Resource
    UserService userService;

    @Override
    public Response<List<EngineInformation>> getEngineInformationList() {
        return Response.success(ENGINE_INFORMATION_LIST);
    }

    @Override
    public Response<List<VehicleDrivingData>> getVehicleDrivingDataList() {
        return Response.success(VEHICLE_DRIVING_DATA_LIST);
    }

    @Override
    public Response<List<VehicleFaultHistory>> getVehicleFaultList() {
        return Response.success(VEHICLE_FAULT_HISTORY_LIST);
    }

    @Override
    public Response<List<VehicleInformation>> getVehicleList() {
        return Response.success(VEHICLE_INFORMATION_LIST);
    }

    @Override
    public Response<List<VehicleTypeInformation>> getVehicleTypeList() {
        return Response.success(VEHICLE_TYPE_INFORMATION_LIST);
    }

    @Override
    public Response<Boolean> permissionCheck(Menu menu) {
        Response<UserBean> UserResponse = userService.getCurrentUser();
        if (!UserResponse.isSuccess()) {
            return Response.error(UserResponse.getMessage());
        }
        UserBean userBean = UserResponse.getData();
        if (ADD_PERMISSION_MAP.containsKey(userBean.getUserType()) && ADD_PERMISSION_MAP.get(userBean.getUserType()).contains(menu.getName())){
            return Response.success(true);
        }
        return Response.success(false);
    }
}
