package com.zzs.temporaryutil.constans;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * All rights Reserved, Designed By GYW
 *
 * @Title: redis缓存相关key常量, 枚举
 * @Package:
 * @Description:
 * @author: wx
 * @date: 2020/1/2 0002 15:13
 * @version: v1.0
 */
public class RedisKeyConstant {

    /**
     * 中间链接符
     */
    private final static String CONNECT_MID_CHAR = ":";

    public static final String ORDER_REC_NUM = "EVNETPUSH:MQ:ORDER_REC_NUM";

    public static final String ORDER_REC_ERROR_NUM = "EVNETPUSH:MQ:ORDER_REC_ERROR_NUM";

    public static final String ORDER_PUSH_SUCC_NUM = "HLHTPUSH:HTTP:ORDER_PUSH_SUCC_NUM";

    public static final String ORDER_PUSH_FAIL_NUM = "HLHTPUSH:HTTP:ORDER_PUSH_FAIL_NUM";

    public static final String STATUS_REC_NUM = "EVNETPUSH:MQ:STATUS_REC_NUM";

    public static final String STATUS_PUSH_SUCC_NUM = "HLHTPUSH:HTTP:STATUS_PUSH_SUCC_NUM";

    public static final String STATUS_PUSH_FAIL_NUM = "HLHTPUSH:HTTP:STATUS_PUSH_FAIL_NUM";

    public static final String ASSET_STATION_GEO = "ASSET:STATION_GEO";
    //站点实时信息
    public static final String REAL_TIME_STA = "REAL_TIME:STA";
    //PCS实时信息
    public static final String REAL_TIME_PCS = "REAL_TIME:PCS";
    //PCS尖峰平谷电量信息
    public static final String REAL_TIME_PCS_ELEC = "REAL_TIME:PCS_ELEC";
    //电池簇实时信息
    public static final String REAL_TIME_ES_CLUSTER = "REAL_TIME:ES_CLUSTER";
    //单体电池实时信息
    public static final String REAL_TIME_ES_BAT = "REAL_TIME:ES_BAT";

    //PCS遥信实时信息
    public static final String REAL_TIME_YX_PCS = "REAL_YX_TIME:PCS";
    //电池簇遥信实时信息
    public static final String REAL_TIME_YX_ES_CLUSTER = "REAL_YX_TIME:ES_CLUSTER";
    //单体电池遥信实时信息
    public static final String REAL_TIME_YX_ES_BAT = "REAL_YX_TIME:ES_BAT";


    /**
     * 组装redis的KEY
     *
     * @param serviceNameEnum 所属服务
     * @param modelNameEnum   所属功能模块 如org、dic等
     * @param keyword         存储关键字
     * @return
     */
    public static String buildRedisKey(ServiceNameEnum serviceNameEnum, ModelNameEnum modelNameEnum, String keyword) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(serviceNameEnum.value)
                .append(CONNECT_MID_CHAR)
                .append(modelNameEnum.value)
                .append(CONNECT_MID_CHAR).append(keyword);
        return stringBuilder.toString();
    }

    /**
     * 组装redis包含日期（yyyy-MM-dd）的KEY
     *
     * @param serviceNameEnum 所属服务
     * @param modelNameEnum   所属功能模块 如org、dic等
     * @param keyword         存储关键字
     * @return
     */
    public static String buildRedisDateKey(ServiceNameEnum serviceNameEnum, ModelNameEnum modelNameEnum, String keyword) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        String dateStr = sdf.format(new Date());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(serviceNameEnum.value)
                .append(CONNECT_MID_CHAR)
                .append(modelNameEnum.value).append("_" + dateStr)
                .append(CONNECT_MID_CHAR).append(keyword);
        return stringBuilder.toString();
    }



    /**
     * 组装redis包含日期（yyyy-MM-dd）的KEY
     *
     * @param serviceNameEnum 所属服务
     * @param modelNameEnum   所属功能模块 如org、dic等
     * @param dateStr         日期（yyyy-MM-dd）
     * @param keyword         存储关键字
     * @return
     */
    public static String buildRedisDateKey(ServiceNameEnum serviceNameEnum, ModelNameEnum modelNameEnum, String dateStr, String keyword) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(serviceNameEnum.value)
                .append(CONNECT_MID_CHAR)
                .append(modelNameEnum.value).append("_" + dateStr)
                .append(CONNECT_MID_CHAR).append(keyword);
        return stringBuilder.toString();
    }

    /**
     * 拼接redis
     *
     * @param type
     * @param stakeId
     * @return
     */
    public static String buildRedisKey(String type, String stakeId) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(type).append(":").append(stakeId);
        return stringBuilder.toString();
    }

    /**
     * 业务分类
     */
    public enum ServiceNameEnum {

        SYSTEM_SERVICE_NAME("SYSTEM", "系统管理服务"),

        ASSET_SERVICE_NAME("ASSET", "资产服务"),

        GPS("GPS", "车辆轨迹"),

        EVNET_ASSET_SERVICE_NAME("EVNET_ASSET", "车联网资产服务"),

        CHARGE_SERVICE_NAME("CHARGE", "充电服务"),

        OPERATION_SERVICE_NAME("OPERATION", "运维服务"),

        AUTH_SERVICE_NAME("AUTH", "授权服务"),

        COMM_SERVICE_NAME("COMM", "通信联调"),
        BILL_SERVICE_NAME("BILL", "计费服务"),
        DISCHARGE_SERVICE_NAME("DISCHARGE", "有序方电服务"),
        CHARGE_REAL_NAME("CHARGE_REAL", "储能实时数据");


        private String value;
        private String desc;

        ServiceNameEnum(String value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public String getDesc() {
            return this.desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    /**
     * 功能模块分类
     */
    public enum ModelNameEnum {

        GROUP_MODEL_NAME("GROUP", "计费组"),

        USER_MODEL_NAME("USER", "用户信息"),

        ORG_MODEL_NAME("ORG", "组织结构"),

        GLOBALCACHESTATIC("GLOBALCACHESTATIC", "资产全局统计参数"),

        STAKE_MODEL_NAME("STAKE", "充电桩"),
        STAKE_MODEL_NAME_SITETYPE("STAKE_SITETYPE", "充电桩"),
        STAKE_MODEL_NAME_DEVTYPE("STAKE_DEVTYPE", "充电桩"),
        STAKE_MODEL_NAME_BY_ORG("STAKE_BY_ORG", "充电桩按组织机构分组"),
        STAKE_MODEL_ZL_COUNT_BY_REG("STAKE_ZL_COUNT_BY_REG", "统计充电桩直流设施数按照区域"),
        STAKE_MODEL_JL_COUNT_BY_REG("STAKE_JL_COUNT_BY_REG", "统计充电桩交流设施数按照区域"),

        STAKE_MODEL_NAME_BY_REG("STAKE_BY_REG", "充电桩按地区分组"),

        STAKE_MODEL_NAME_BY_REG_1("STAKE_BY_REG_1", "充电桩按地区分组"),

        STAKE_MODEL_NAME_BY_STA("STAKE_BY_STA", "充电桩按站点分组"),

        CONNECTOR_MODEL_NAME("CONNECTOR", "充电枪"),

        EV("EV", "车辆信息"),

        TRACK("TRACK", "轨迹信息"),

        CONNECTOR_MODEL_NAME_ASSET("CONNECTOR_ASSET", "充电枪按资产码"),

        CONNECTOR_MODEL_NAME_SITETYPE("CONNECTOR_SITETYPE", "充电枪"),

        CONNECTOR_MODEL_NAME_BY_REG("CONNECTOR_BY_REG", "充电枪按地区分组"),

        CONNECTOR_MODEL_NAME_BY_STA("CONNECTOR_BY_STA", "充电枪按站点分组"),

        CONNECTOR_MODEL_NAME_BY_FACT("CONNECTOR_BY_FACT", "充电枪按厂家分组"),

        DEVMODEL_MODEl_SERVICE_NAME("DEVMODEL", "设备型号"),

        CUSTOM_MODEl_NAME("CUSTOM", "用户"),
        THERMOSTAT_MODEl_NAME("THERMOSTAT", "温控器"),

        THERMOSTAT_MODEL_NAME_BY_TRANS("THERMOSTAT_BY_TRANS", "温控器按配变分组"),
        THERMOSTAT_MODEL_NAME_BY_ORG("THERMOSTAT_BY_ORG", "温控器按组织分组"),
        THERMOSTAT_MODEL_NAME_BY_REG("THERMOSTAT_BY_REG", "温控器按地区分组"),
        TRANS_MODEL_NAME_BY_REG("TRANS_BY_REG", "配变按地区分组"),
        TRANS_MODEL_NAME_BY_ORG("TRANS_BY_ORG", "配变按组织分组"),
        TRANS_MODEL_NAME_NEXT("TRANS_NEXT", "配变下面所有配变"),

        FACT_MODEL_NAME("FACT", "厂家信息"),

        AREA_MODEL_NAME("AREA", "台区信息"),


        STATION_MODEL_NAME("STATION", "站点"),

        STATION_MODEL_NAME_BUILDTYPE("STATION_BUILDTYPE", "站点"),

        STATION_MODEL_NAME_BY_ORG("STATION_BY_ORG", "站点按组织机构分组"),

        STATION_MODEL_NAME_BY_REG("STATION_BY_REG", "站点按地区分组"),
        STATION_MODEL_COUNT_BY_REG("STATION_COUNT_BY_REG", "站点按地区分组统计数量"),
        STATION_MODEL_H_COUNT_BY_REG("STATION_H_BY_REG", "站点按地区分组统计高速/城市充电站数量"),
        STATION_MODEL_C_COUNT_BY_REG("STATION_C_BY_REG", "站点按地区分组统计城市充电站数量"),
        STATION_MODEL_N_A_R_BY_REG("STATION_N_A_R_BY_REG", "站点按地区分组充电站名称、区域id、地址"),
        TRANS_MODEL_NAME("TRANS", "配变"),

        ZONE_MODEL_NAME("ZONE", "园区"),

        USER_RESOURCE("USER_RESOURCE", "用户拥有的资源"),

        REGION_MODEL_NAME("REGION", "区域"),

        REGION_MODEL_AREA("REGION:AREA", "地区下面所有区的ID集合"),

        AREA_REGION_NAME("AREA", "地区下面所有区的ID集合"),
        PROVINCE_CITY_NAME("PROVINCE_CITY", "省下面所有市的ID集合"),
        AREA_REGION_IDS("AREA_IDS", "所有区的ID集合"),
        REGION_TREE("RECommandLineRunnerGIONTREE", "所有层级"),
        PROVINCE_NEXT_REGIDS("NEXT_REGIDS", "省下面市的ids集合"),

        DIC_MODEL_NAME("DIC", "字典"),

        STA_COUNT("STACOUNT", "站点数量"),

        STAKE_COUNT("STAKECOUNT", "设备数量"),

        CHAN_MODEL_NAME("CHAN", "通道"),

        CONV_MODEL_NAME("CONV", "规约"),


        //----------------------------------
        CHARGE_POWER_BY_REG("POWER_BY_REG", "充电电量按照地区统计"),
        CHARGE_JE_BY_REG("JE_BY_REG", "区下充电金额"),
        CHARGE_NUM_BY_REG("NUM_BY_REG", "充电次数按地区统计"),

        CHARGE_POWER_BY_STA("POWER_BY_STA", "充电电量按照站点统计"),
        CHARGE_JE_BY_STA("JE_BY_STA", "站点充电金额"),
        CHARGE_NUM_BY_STA("NUM_BY_STA", "充电次数按站点统计"),

        CHARGE_POWER_BY_DEV("POWER_BY_DEV", "充电电量按照站点统计"),
        CHARGE_JE_BY_DEV("JE_BY_DEV", "站点充电金额"),
        CHARGE_NUM_BY_DEV("NUM_BY_DEV", "充电次数按站点统计"),

        //----------------------------------------
        CHARGE_DEV_U("DEV_U", "设备今日电压曲线"),
        CHARGE_DEV_I("DEV_I", "设备今日电流曲线"),
        CHARGE_DEV_P("DEV_P", "设备今日功率曲线"),

        CHARGE_DEV_POWER_LINE("DEV_POWER_LINE", "设备今日充电量曲线"),
        CHARGE_DEV_SOC_LINE("DEV_SOC_LINE", "设备今日SOC曲线"),


        CHARGE_DEV_LOAD("DEV_LOAD", "设备今日总负荷"),
        CHARGE_DEV_POWER("DEV_POWER", "设备今日充电量"),
        CHARGE_DEV_TIMES("DEV_TIMES", "设备今日充电次数"),
        CHARGE_DEV_MONEY("DEV_MONEY", "设备今日充电金额"),

        CHARGE_STA_POWER("STA_POWER", "站点今日总电量"),
        CHARGE_STA_TIMES("STA_TIMES", "站点今日充电次数"),
        CHARGE_STA_MONEY("STA_MONEY", "站点今日充电金额"),

        CHARGE_REGION_POWER("REGION_POWER", "区域今日充电电量"),
        CHARGE_REGION_TIMES("REGION_TIMES", "区域今日充电次数"),
        CHARGE_REGION_MONEY("REGION_MONEY", "区域今日充电金额"),

        CHARGE_ORG_POWER("ORG_POWER", "单位今日充电电量"),
        CHARGE_ORG_TIMES("ORG_TIMES", "单位今日充电次数"),
        CHARGE_ORG_MONEY("ORG_MONEY", "单位今日充电金额"),

        CHARGE_DEV_STATUS_DURATION("DEV_STATUS_DURATION", "状态时长设备"),

        CHARGE_STA_STATUS_DURATION("STA_STATUS_DURATION", "状态时长站点"),

        CHARGE_REG_STATUS_DURATION("REG_STATUS_DURATION", "状态时长省市区"),

        CHARGE_ORG_STATUS_DURATION("ORG_STATUS_DURATION", "状态时长组织机构"),

        CHARGE_STA_STATUS_COUNT("STA_STATUS_COUNT", "站点设备状态个数"),

        CHARGE_STA_P("STA_P_LINE", "站点今日功率曲线"),

        CHARGE_STA_POWER_LINE("STA_POWER_LINE", "站点今日充电电量曲线"),

        CHARGE_STA_CHARGE_LINE("STA_CHARGE_LINE", "站点今日充电负荷曲线"),

        CHARGE_STA_LOAD("STA_LOAD", "站点今日功率"),

        CHARGE_ORG_P("ORG_P", "单位今日充电功率曲线"),

        CHARGE_ORG_LOAD("ORG_LOAD", "单位今日总负荷"),

        CHARGE_REGION_LOAD("REGION_LOAD", "区域今日总负荷"),

        CHARGE_REGION_P("REGION_P", "区域今日充电功率曲线"),

        CHARGE_ORG_STATUS_COUNT("ORG_STATUS_COUNT", "组织机构设备状态个数"),

        CHARGE_PROVINCE_REG_STATUS_COUNT("REG_PROVINCE_STATUS_COUNT", "省级区域设备状态个数"),

        CHARGE_CITY_REG_STATUS_COUNT("REG_CITY_STATUS_COUNT", "市级区域设备状态个数"),

        CHARGE_REG_STATUS_COUNT("REG_STATUS_COUNT", "区域设备状态个数"),

        CHARGE_FACT_STATUS_COUNT("FACT_STATUS_COUNT", "厂家设备状态个数"),

        CHARGE_ORG_CHARGE_LINE("ORG_CHARGE_LINE", "组织机构今日充电负荷曲线"),

        CHARGE_REG_CHARGE_LINE("REG_CHARGE_LINE", "区域今日充电负荷曲线"),

        CHARGE_CITY_REG_CHARGE_LINE("REG_CITY_CHARGE_LINE", "市级区域今日充电负荷曲线"),

        CHARGE_PROVINCE_REG_CHARGE_LINE("REG_PROVINCE_CHARGE_LINE", "省级区域今日充电负荷曲线"),

        CHARGE_FACT_CHARGE_LINE("FACT_CHARGE_LINE", "厂家今日充电负荷曲线"),

        CHARGE_ORG_POWER_LINE("ORG_POWER_LINE", "单位今日充电电量曲线"),

        CHARGE_REGION_POWER_LINE("REG_POWER_LINE", "区域今日充电电量曲线"),
        CHARGE_CITY_REGION_POWER_LINE("REG_CITY_POWER_LINE", "市级区域今日充电电量曲线"),
        CHARGE_PROVINCE_REGION_POWER_LINE("REG_PROVINCE_POWER_LINE", "省级区域今日充电电量曲线"),
        EV_MODEL_NAME("EV", "车辆信息"),
        CHARGE_FACT_POWER_LINE("FACT_POWER_LINE", "厂家今日充电电量曲线"),

        ES_MODEL_NAME("ES", "储能变流器"),
        ES_COUNT("ES_COUNT", "储能变流器总数量"),
        ES_REAL_P_LINE("P", "变流器实时负荷曲线"),
        ES_MODEL_NAME_BY_ORG("ES_BY_ORG", "变流器按组织机构分组"),
        ES_MODEL_NAME_BY_REG("ES_BY_REG", "变流器按区域分组"),
        ES_MODEL_NAME_BY_STA("ES_BY_STA", "变流器按站点分组"),
        ES_CLUSTER_MODEL_NAME_BY_PCS("ES_CLUSTER_BY_PCS", "电池簇按照PCS分组"),
        ES_BAT_MODEL_NAME_BY_CLUSTER("ES_BAT_BY_CLUSTER", "单体电池按照电池簇划分"),
        ES_BAT_MODEL_NAME("ES_BAT", "单体电池电池"),
        ES_BAT_CAP("ES_BAT_CAP", "单体电池总容量"),
        ES_CLUSTER_MODEL_NAME("ES_CLUSTER", "电池簇"),
        ES_CLUSTER_REAL_CHARGE_LINE("ES_CLUSTER_CHARGE_LINE", "电池簇充电曲线"),
        ES_CLUSTER_REAL_DISCHARGE_LINE("ES_CLUSTER_DISCHARGE_LINE", "电池簇放电曲线"),
        ES_CLUSTER_MAXU_LINE("ES_CLUSTER_MAXU_LINE", "电池簇内最高电压曲线"),
        ES_CLUSTER_MAXTEMP_LINE("ES_CLUSTER_MAXTEMP_LINE", "电池簇内最高温度曲线"),
        ES_CLUSTER_AVGU_LINE("ES_CLUSTER_AVGU_LINE", "电池簇内平均电压曲线"),
        ES_CLUSTER_AVGTEMP_LINE("ES_CLUSTER_AVGTEMP_LINE", "电池簇内平均温度曲线"),
        ES_CLUSTER_SOC_LINE("ES_CLUSTER_SOC_LINE", "电池簇SOC"),
        ES_CLUSTER_SOH_LINE("ES_CLUSTER_SOH_LINE", "电池簇SOH"),
        STA_P_LINE("STA_P_LINE", "站点P曲线"),
        STA_CHARGEP_LINE("STA_CHARGEP_LINE", "站点充电功率曲线"),
        STA_DISCHARGEP_LINE("STA_DISCHARGEP_LINE", "站点放电功率曲线"),
        COMM_YC_MODEL("COMM_YC", "遥测点号"),
        COMM_YX_MODEL("COMM_YX", "遥信点号"),

        COMM_YC_MODEL_BY_NO("COMM_YC_BEAN", "遥测根据点号保存实体"),
        COMM_YX_MODEL_BY_NO("COMM_YX_BEAN", "遥信根据点号保存实体");


        private String value;
        private String desc;

        ModelNameEnum(String value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public String getDesc() {
            return this.desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}