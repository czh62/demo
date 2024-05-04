package com.example.demo.controller;

import com.example.demo.domain.engineInformation.EngineInformation;
import com.example.demo.domain.menu.MenuReq;
import com.example.demo.domain.noticeAndAnnouncement.NoticeAndAnnouncement;
import com.example.demo.domain.response.Response;
import com.example.demo.domain.menu.Menu;
import com.example.demo.domain.user.UserBean;
import com.example.demo.domain.vehicleDrivingData.VehicleDrivingData;
import com.example.demo.domain.vehicleFaultHistory.VehicleFaultHistory;
import com.example.demo.domain.vehicleInformation.VehicleInformation;
import com.example.demo.domain.vehicleTypeInformation.VehicleTypeInformation;
import com.example.demo.service.MenuService;
import com.example.demo.service.NoticeService;
import com.example.demo.service.UserService;
import com.example.demo.service.VehicleService;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.demo.config.SystemConst.MENU_MAP;

@RestController
@Log4j2
@RequestMapping("/api")
public class BaseServiceController {

    @Resource
    MenuService menuService;

    @Resource
    UserService userService;

    @Resource
    VehicleService vehicleService;

    @Resource
    private NoticeService noticeService;


    @RequestMapping("/menuList")
    @ResponseBody
    public Response<List<Menu>> menuList() {
        return menuService.getMenuList();
    }

    @RequestMapping("/userList")
    @ResponseBody
    public Response<Map<String, Object>> userList() {
        Response<List<UserBean>> response = userService.getUserList();
        if (!response.isSuccess()) {
            return Response.error(response.getMessage());
        }
        Response<Integer> countResponse = userService.getUserCount();
        if (!countResponse.isSuccess()) {
            return Response.error(countResponse.getMessage());
        }
        Map<String, Object> result = new HashMap<>();
        result.put("userCount", countResponse.getData());
        result.put("userList", response.getData());
        return Response.success(result);
    }

    @RequestMapping("/engineInformationList")
    @ResponseBody
    public Response<List<EngineInformation>> engineInformationList() {
        return vehicleService.getEngineInformationList();
    }

    @RequestMapping("/vehicleDrivingDataList")
    @ResponseBody
    public Response<List<VehicleDrivingData>> vehicleDrivingDataList() {
        return vehicleService.getVehicleDrivingDataList();
    }

    @RequestMapping("/vehicleFaultList")
    @ResponseBody
    public Response<List<VehicleFaultHistory>> vehicleFaultList() {
        return vehicleService.getVehicleFaultList();
    }

    @RequestMapping("/vehicleList")
    @ResponseBody
    public Response<List<VehicleInformation>> vehicleList() {
        return vehicleService.getVehicleList();
    }

    @RequestMapping("/vehicleTypeList")
    @ResponseBody
    public Response<List<VehicleTypeInformation>> vehicleTypeList() {
        return vehicleService.getVehicleTypeList();
    }


    @RequestMapping("/noticeAndAnnouncementList")
    @ResponseBody
    public Response<List<NoticeAndAnnouncement>> noticeAndAnnouncementList() {
        return noticeService.getNoticeList();
    }

    @RequestMapping("/permissionCheck")
    @ResponseBody
    public Response<Boolean> permissionCheck(@RequestBody MenuReq menuReq) {
        Menu menuObj = MENU_MAP.get(menuReq.getName());
        return vehicleService.permissionCheck(menuObj);
    }
}

