package com.example.demo.service.impl;

import com.example.demo.domain.menu.Menu;
import com.example.demo.domain.response.Response;
import com.example.demo.domain.user.UserBean;
import com.example.demo.service.MenuService;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.config.SystemConst.HOME_MENU;
import static com.example.demo.config.SystemConst.MENU_MAP;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    UserService userService;

    @Override
    public Response<List<Menu>> getMenuList() {
        Response<UserBean> response = userService.getCurrentUser();
        if (!response.isSuccess()) {
            return Response.error(response.getMessage());
        }
        UserBean user = response.getData();
        if (user != null) {
            List<Menu> menuList = new ArrayList<>();
            switch (user.getUserType()) {
                case ADMIN:
                    menuList.add(HOME_MENU);
                    menuList.add(MENU_MAP.get("vehicleManagement"));
                    menuList.add(MENU_MAP.get("engineInformationManagement"));
                    menuList.add(MENU_MAP.get("vehicleTypeManagement"));
                    menuList.add(MENU_MAP.get("userManagement"));
                    menuList.add(MENU_MAP.get("vehicleFaultHistory"));
                    menuList.add(MENU_MAP.get("vehicleDrivingData"));
                    menuList.add(MENU_MAP.get("noticeAndAnnouncement"));
                    break;
                case VEHICLE_MANUFACTURER:
                case VEHICLE_DEALER:
                case VEHICLE_OWNER:
                    menuList.add(HOME_MENU);
                    menuList.add(MENU_MAP.get("vehicleManagement"));
                    menuList.add(MENU_MAP.get("engineInformationManagement"));
                    menuList.add(MENU_MAP.get("vehicleTypeManagement"));
                    menuList.add(MENU_MAP.get("vehicleFaultHistory"));
                    menuList.add(MENU_MAP.get("vehicleDrivingData"));
                default:
                    break;
            }
            return Response.success(menuList);
        }
        return Response.error("获取用户信息失败");
    }
}
