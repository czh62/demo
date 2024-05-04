package com.example.demo.config;

import com.example.demo.domain.engineInformation.EngineInformation;
import com.example.demo.domain.enums.AuditStateEnum;
import com.example.demo.domain.enums.EmissionStandardEnum;
import com.example.demo.domain.enums.IconEnum;
import com.example.demo.domain.enums.UserTypeEnum;
import com.example.demo.domain.menu.Menu;
import com.example.demo.domain.meta.Meta;
import com.example.demo.domain.noticeAndAnnouncement.NoticeAndAnnouncement;
import com.example.demo.domain.user.UserBean;
import com.example.demo.domain.vehicleDrivingData.VehicleDrivingData;
import com.example.demo.domain.vehicleFaultHistory.VehicleFaultHistory;
import com.example.demo.domain.vehicleInformation.VehicleInformation;
import com.example.demo.domain.vehicleTypeInformation.VehicleTypeInformation;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class SystemConst {
    /**
     * 用户信息
     * 可以按需求添加更多用户信息
     * 这里仅添加了管理员、经销商、厂商、车主每种类型的一个用户
     *
     * @添加方法：复制一行然后修改用户名、密码、类型、等信息例(每种的枚举类已经given，可以复制使用)
     * @注意：除最后一行外其他行需要加逗号,最后一行不需要加逗号
     * @建议：在第一行按ctrl+D复制一行，然后修改用户名、密码、类型、等信息
     */
    public static final Map<String, UserBean> USER_MAP = new HashMap<String, UserBean>(
            /*  "用户名", new UserBean(唯一ID, "用户名", "密码", 用户类型枚举, "邮箱", "手机号"),*/
            Map.of(

                    "admin", new UserBean(0, "admin", "admin", UserTypeEnum.ADMIN, "admin@admin.com", "18811111111"),
                    "dealer", new UserBean(1, "dealer", "123", UserTypeEnum.VEHICLE_DEALER, "dealer@dealer.com", "18822222222"),
                    "manufacturer", new UserBean(2, "manufacturer", "123", UserTypeEnum.VEHICLE_MANUFACTURER, "manufacturer@manufacturer.com", "18833333333"),
                    "owner", new UserBean(3, "owner", "123", UserTypeEnum.VEHICLE_OWNER, "owner@owner.com", "18844444444")
            )
    );

    /**
     * 首页
     * 车辆信息管理   (车主用户录入、可查询｜汽车制造商、汽车销售商可查询)
     * 发动机信息管理 (汽车制造商可查询、新建｜汽车销售商、车主用户可查询)
     * 车型信息管理   (汽车制造商可查询、新建｜汽车销售商、车主用户可查询)
     * 用户管理
     * 车辆故障历史   (汽车制造商可查询｜汽车销售商、车主用户可以查询和录入)
     * 车辆行驶数据   (车主用户录入、可查询｜汽车制造商、汽车销售商可查询)
     * 通知公告
     */

    public static final Menu HOME_MENU = new Menu("/home", "PageHome", "/home/index.vue", new Meta(IconEnum.HomeFilled, "router.home_page", false, true, false));
    public static final Map<String, Menu> MENU_MAP = new HashMap<String, Menu>(
            Map.of(
                    "vehicleManagement", new Menu("/vehicleManagement", "vehicleManagement", "/vehicleManagement/index.vue", new Meta(IconEnum.HomeFilled, "router.vehicle_management", false, false, false)),
                    "engineInformationManagement", new Menu("/engineInformationManagement", "engineInformationManagement", "/engineInformationManagement/index.vue", new Meta(IconEnum.HomeFilled, "router.engine_information_management", false, false, false)),
                    "vehicleTypeManagement", new Menu("/vehicleTypeManagement", "vehicleTypeManagement", "/vehicleTypeManagement/index.vue", new Meta(IconEnum.HomeFilled, "router.vehicle_type_management", false, false, false)),
                    "userManagement", new Menu("/userManagement", "userManagement", "/userManagement/index.vue", new Meta(IconEnum.HomeFilled, "router.user_management", false, false, false)),
                    "vehicleFaultHistory", new Menu("/vehicleFaultHistory", "vehicleFaultHistory", "/vehicleFaultHistory/index.vue", new Meta(IconEnum.HomeFilled, "router.vehicle_fault_history", false, false, false)),
                    "vehicleDrivingData", new Menu("/vehicleDrivingData", "vehicleDrivingData", "/vehicleDrivingData/index.vue", new Meta(IconEnum.HomeFilled, "router.vehicle_driving_data", false, false, false)),
                    "noticeAndAnnouncement", new Menu("/noticeAndAnnouncement", "noticeAndAnnouncement", "/noticeAndAnnouncement/index.vue", new Meta(IconEnum.HomeFilled, "router.notice_and_announcement", false, false, false))
            )
    );

    /**
     * “添加”操作的权限管理
     * 这里仅添加了管理员、经销商、厂商、车主每种类型的权限，实际使用时可以添加更多权限
     * @注意：不同类别用户菜单权限不在SYSTEM_CONST中，而是MenuService中进行权限判断
     */
    public static final Map<UserTypeEnum, List<String>>  ADD_PERMISSION_MAP = new HashMap<>(
            Map.of(
                    UserTypeEnum.ADMIN, List.of("vehicleManagement", "engineInformationManagement", "vehicleTypeManagement", "userManagement", "vehicleFaultHistory", "vehicleDrivingData", "noticeAndAnnouncement"),

                    UserTypeEnum.VEHICLE_DEALER, List.of("vehicleFaultHistory"),

                    UserTypeEnum.VEHICLE_MANUFACTURER, List.of("engineInformationManagement", "vehicleTypeManagement"),

                    UserTypeEnum.VEHICLE_OWNER, List.of("vehicleManagement", "vehicleDrivingData", "noticeAndAnnouncement")
            )
    );

    /**
     * 系统公告
     * 这里仅添加了两个公告，实际使用时可以添加更多公告
     * 同理可以ctrl+D复制第一行添加更多公告
     */
    public static final List<NoticeAndAnnouncement> NOTICE_AND_ANNOUNCEMENT_LIST = List.of(
            new NoticeAndAnnouncement("标题1", "内容1"),
            new NoticeAndAnnouncement("标题2", "内容2")
    );
    /**
     * 发动机信息
     * 这里仅添加了两个发动机信息，实际使用时可以添加更多发动机信息
     * 同理可以ctrl+D复制第一行添加更多发动机信息
     */
    public static final List<EngineInformation> ENGINE_INFORMATION_LIST = List.of(
            new EngineInformation("发动机型号", "生产企业", "发动机排量", "排气后处理系统形式"),
            new EngineInformation("发动机型号", "生产企业", "发动机排量", "排气后处理系统形式")
    );
    /**
     * 车辆行驶数据
     * 这里仅添加了两个车辆行驶数据，实际使用时可以添加更多车辆行驶数据
     * 同理可以ctrl+D复制第一行添加更多车辆行驶数据
     */
    public static final List<VehicleDrivingData> VEHICLE_DRIVING_DATA_LIST = List.of(
            new VehicleDrivingData("发动机状态", "刹车状态", "轮胎压力", "行驶里程数", "故障与警告信息", "踏板使用程度"),
            new VehicleDrivingData("发动机状态", "刹车状态", "轮胎压力", "行驶里程数", "故障与警告信息", "踏板使用程度")
    );
    /**
     * 车辆故障历史
     * 这里仅添加了两个车辆故障历史，实际使用时可以添加更多车辆故障历史
     * 同理可以ctrl+D复制第一行添加更多车辆故障历史
     */
    public static final List<VehicleFaultHistory> VEHICLE_FAULT_HISTORY_LIST = List.of(
            new VehicleFaultHistory("车牌号", "终端号", "接收时间", "OBD诊断协议", "车辆识别码", "故障码总数", "有效故障码列表"),
            new VehicleFaultHistory("车牌号", "终端号", "接收时间", "OBD诊断协议", "车辆识别码", "故障码总数", "有效故障码列表")
    );
    /**
     * 车辆信息
     * 这里仅添加了三个车辆信息，实际使用时可以添加更多车辆信息
     * 同理可以ctrl+D复制第一行添加更多车辆信息
     * @注意：车辆信息的审核状态为枚举类，直接复制相应的枚举值即可
     */
    public static final List<VehicleInformation> VEHICLE_INFORMATION_LIST = List.of(
            new VehicleInformation("车牌号", AuditStateEnum.PENDING, "车架号", "车牌颜色"),
            new VehicleInformation("车牌号", AuditStateEnum.APPROVED, "车架号", "车牌颜色"),
            new VehicleInformation("车牌号", AuditStateEnum.REJECTED, "车架号", "车牌颜色")
    );
    /**
     * 车型信息
     * 这里仅添加了两个车型信息，实际使用时可以添加更多车型信息
     * 同理可以ctrl+D复制第一行添加更多车型信息
     * @注意：车型信息的审核状态为枚举类，直接复制相应的枚举值即可
     * @注意：车型信息的排放标准为枚举类，有I-VI六种，直接复制相应的枚举值即可
     */
    public static final List<VehicleTypeInformation> VEHICLE_TYPE_INFORMATION_LIST = List.of(
            new VehicleTypeInformation("车辆型号", "发动机型号", EmissionStandardEnum.I, AuditStateEnum.PENDING, "整车生产企业","厂牌品牌"),
            new VehicleTypeInformation("车辆型号", "发动机型号", EmissionStandardEnum.III, AuditStateEnum.APPROVED, "整车生产企业","厂牌品牌"),
            new VehicleTypeInformation("车辆型号", "发动机型号", EmissionStandardEnum.V, AuditStateEnum.REJECTED, "整车生产企业","厂牌品牌")
    );
}
