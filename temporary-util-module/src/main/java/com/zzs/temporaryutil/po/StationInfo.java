/**
 * Copyright 2016 aTool.org
 */
package com.zzs.temporaryutil.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * 充电站信息
 *
 * 用于描述充电站的信息，包含充电站的基本信息、服务信息、业务信 息等，
 * 其中基本信息的设备所属方 ID 为充电设备所属方的组织机构代码。
 * 站点类型分为四大类：公共、专用、居民（小）区、其他:
 * - 其中公共 包括：高速、公共服务场所、公共停车场、城市交通节点、加油站以及具 备停车条件的充电站点；
 * - 专用包括：政府机关、公共机构、企业事业单位、 公交、环卫、物流、出租车、港口码头等特定范围内或是服务于特定型号 或特定领域车辆的充电站点；
 * - 居民（小）区指在居民（小）区建设的充电 站点；
 * - 其他指未包括在公共、专用、居民（小）区中的其他站点类型。
 *
 * @author zhuzs
 * @date 2022/8/2 09:35
 */
@Data
@JsonRootName("StationInfo")
@Schema(description = "充电站信息")
public class StationInfo{
    /**
     * 必填
     * 充电站 ID：运营商自定义的唯一 编码
     */
    @NotBlank
    @JsonProperty("StationID")
    @Schema(description = "充电站 ID：运营商自定义的唯一 编码")
    private String stationId;

    /**
     * 必填
     * 运营商 ID：统一社会信用代码
     */
    @JsonProperty("OperatorID")
    @Schema(description = "运营商 ID：统一社会信用代码")
    private String operatorId;

    /**
     * 必填
     * 设备所属方 ID：设备所属方组织机构 代码
     */
    @NotBlank
    @JsonProperty("EquipmentOwnerID")
    @Schema(description = "设备所属方 ID：设备所属方组织机构 代码")
    private String equipmentOwnerId;

    /**
     * 必填
     * 充电站名称：充电站名称的描述
     */
    @NotBlank
    @JsonProperty("StationName")
    @Schema(description = "充电站名称：充电站名称的描述")
    private String stationName;

    /**
     * 必填
     * 充电站国家 代码：比如 CN
     */
    @NotBlank
    @JsonProperty("CountryCode")
    @Schema(description = "充电站国家 代码：比如 CN")
    private String countryCode;

    /**
     * 必填
     * 充电站省市 辖区编码：填写内容为参照 GB/T 2260-2015，以民政部 发布最新数据为准
     */
    @NotBlank
    @JsonProperty("AreaCode")
    @Schema(description = "充电站省市 辖区编码：填写内容为参照 GB/T 2260-2015，以民政部 发布最新数据为准")
    private String areaCode;

    /**
     * 必填
     * 详细地址
     */
    @NotBlank
    @JsonProperty("Address")
    @Schema(description = "详细地址")
    private String address;

    /**
     * 站点电话：能够联系场站工作人员 进行协助的联系电话
     */
    @JsonProperty("StationTel")
    @Schema(description = "站点电话：能够联系场站工作人员 进行协助的联系电话")
    private String stationTel;

    /**
     * 必填
     * 服务电话：平台服务电话， 例如 400 的电话
     */
    @NotBlank
    @JsonProperty("ServiceTel")
    @Schema(description = "服务电话：平台服务电话， 例如 400 的电话")
    private String serviceTel;

    /**
     * 必填
     * 站点类型：1：公共充电区 2：专用充电区 3：居民充电区 255：其他
     */
    @NotNull
    @JsonProperty("StationType")
    @Schema(description = "站点类型：1：公共充电区 2：专用充电区 3：居民充电区 255：其他")
    private Integer stationType;

    /**
     * 必填
     * 站点状态：0：未知 1：建设中 5：关闭下线 6：维护中 50：正常使用
     */
    @NotNull
    @JsonProperty("StationStatus")
    @Schema(description = "站点状态：0：未知 1：建设中 5：关闭下线 6：维护中 50：正常使用")
    private Integer stationStatus;

    /**
     * 必填
     * 车位数量：可停放进行充电的车 位总数，默认：0 未知
     */
    @NotNull
    @JsonProperty("ParkNums")
    @Schema(description = "车位数量：可停放进行充电的车 位总数，默认：0 未知")
    private Integer parkNums;

    /**
     * 必填
     * 经度：GCJ-02 坐标系
     */
    //	@JsonSerialize(using = Double6Serialize.class)
    @NotNull
    @JsonProperty("StationLng")
    @Schema(description = "经度：GCJ-02 坐标系")
    private Double stationLng;

    /**
     * 必填
     * 纬度：GCJ-02 坐标系
     */
    //	@JsonSerialize(using = Double6Serialize.class)
    @NotNull
    @JsonProperty("StationLat")
    @Schema(description = "纬度：GCJ-02 坐标系")
    private Double stationLat;

    /**
     * 站点引导：描述性文字，用于引导 车主找到充电车位
     */
    @JsonProperty("SiteGuide")
    @Schema(description = "站点引导：描述性文字，用于引导 车主找到充电车位")
    private String siteGuide;

    /**
     * 必填
     * 建设场所：
     * - 101：公共服务场所 102：公共停车场 103：城市交通节点 104：加油站 105：具备停车条件的 充电区域 106：高速服务区
     *   201：政府机关 202：公共机构 203：企业事业单位 204：公交 205：环卫 206：物流 207：出租车 208：港口码头 301：居民（小）区 255：其他
     */
    @NotNull
    @JsonProperty("Construction")
    @Schema(description = "建设场所")
    private Integer construction;

    /**
     * 必填
     * 站点照片：充电设备照片、充电车 位照片、停车场入口照片
     */
    @NotEmpty
    @JsonProperty("Pictures")
    @Schema(description = "站点照片：充电设备照片、充电车 位照片、停车场入口照片")
    private List<String> pictures;

    /**
     * 使用车型描述：描述该站点接受的车大小以及类型，如大巴、物流车、私家乘用 车、出租车等
     */
    @JsonProperty("MatchCars")
    @Schema(description = "使用车型描述：描述该站点接受的车大小以及类型，如大巴、物流车、私家乘用 车、出租车等")
    private String matchCars;

    /**
     * 车位楼层 及 数量描述：车位楼层以及数量信息
     */
    @JsonProperty("ParkInfo")
    @Schema(description = "车位楼层 及 数量描述：车位楼层以及数量信息")
    private String parkInfo;

    /**
     * 停车场产权方：停车场产权人
     */
    @JsonProperty("ParkOwner")
    @Schema(description = "停车场产权方：停车场产权人")
    private String parkOwner;

    /**
     * 必填
     * 投运日期：yyyy-MM-dd
     */
//    @JsonInclude(JsonInclude.Include.NON_NULL)//NULL时不序列化
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @JsonProperty("OpenForBusinessDate")
    @NotBlank
    @Schema(description = "投运日期：yyyy-MM-dd")
    private String openForBusinessDate;

    /**
     * 停车场管理方：停车场管理人（如：XX 物业）
     */
    @JsonProperty("ParkManager")
    @Schema(description = "停车场管理方：停车场管理人（如：XX 物业）")
    private String parkManager;

    /**
     * 必填
     * 全天开放：是否全天开放 0：否 1：是
     */
    @NotNull
    @JsonProperty("OpenAllDay")
    @Schema(description = "全天开放：是否全天开放 0：否 1：是")
    private Integer openAllDay;

    /**
     * 必填
     * 营业时间：营业时间描述
     */
    @NotBlank
    @JsonProperty("BusineHours")
    @Schema(description = "营业时间：营业时间描述")
    private String busineHours;

    /**
     * 必填
     * 最低单价：最低充电电费率
     */
    @NotBlank
    @JsonProperty("MinElectricityPrice")
    @Schema(description = "最低单价：最低充电电费率")
    private String minElectricityPrice;

    /**
     * 充电电费率：桩可能有不同的计费策略，此处的费率仅能代表其中一种策略，仅供参考，最终以计费策略查询接口为准示例
     * [{"StartTime":"0000 00","Price":"1.0000 "},{"StartTime":"12 0000","Price":"1.20 00"}]
     */
    @JsonProperty("ElectricityFee")
    @Schema(description = "充电电费率：桩可能有不同的计费策略，此处的费率仅能代表其中一种策略，仅供参考，最终以计费策略查询接口为准示例")
    private String electricityFee;

    /**
     * 服务费率 桩可能有不同的计费 策略，此处的费率仅能 代表其中一种策略，仅 供参考，最终以计费策 略查询接口为准示例
     * [{"StartTime":"0000 00","Price":"0.5000 "},{"StartTime":"12 0000","Price":"0.70 00"}]
     */
    @JsonProperty("ServiceFee")
    @Schema(description = "服务费率 桩可能有不同的计费 策略，此处的费率仅能 代表其中一种策略，仅 供参考，最终以计费策 略查询接口为准示例")
    private String serviceFee;

    /**
     * 免费停车: 是否停车免费 0：否 1：是
     */
    @JsonProperty("ParkFree")
    @Schema(description = "免费停车: 是否停车免费 0：否 1：是")
    private Integer ParkFree;

    /**
     * 停车费:n 停车费率描述
     */
    @JsonProperty("ParkFee")
    @Schema(description = "停车费:n 停车费率描述")
    private String parkFee;

    /**
     * 是否支持预约：充电设备是否需要提前预约后才能使用。0 为不支持预约，1 为支 持预约。不填默认为 0。
     */
    @JsonProperty("SupportOrder")
    @Schema(description = "是否支持预约：充电设备是否需要提前预约后才能使用。0 为不支持预约，1 为支 持预约。不填默认为 0")
    private Integer supportOrder;

    /**
     * 备注
     */
    @JsonProperty("Remark")
    @Schema(description = "备注")
    private String remark;

    /**
     * 充电设备信息：该充电站所有充电设备
     */
    @JsonProperty("EquipmentInfos")
    @Schema(description = "充电设备信息")
    private EquipmentInfo[] equipmentInfos;
}