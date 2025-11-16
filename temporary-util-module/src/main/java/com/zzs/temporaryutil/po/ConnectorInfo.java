package com.zzs.temporaryutil.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * 充电设备接口信息
 *
 * 对充电设备接口的基本信息对象的描述，包含充电设备接口编码、充电设备接口名称、充电设备接口类型、额定电压、额定电流、额定功率等。
 * 如果设备为交流，其中额定电压上限以及额定电压下限可填入一样的 值
 *
 * @author zhuzs
 * @date 2022/8/2 10:55 
 */
@Data
@Schema(description = "充电设备接口信息")
@JsonRootName("ConnectorInfo")
public class ConnectorInfo implements Serializable {
    private static final long serialVersionUID = -7492473163045357996L;

    /**
     * 必填
     * 充电设备接口编码：充电设备接口编码，同一运营商内唯一
     */
    @NotBlank(message = "充电设备接口编码不能为空！")
    @JsonProperty("ConnectorID")
   @Schema(description = "充电设备接口编码：充电设备接口编码，同一运营商内唯一")
    private String connectorId;

    /**
     * 必填
     * 充电设备接口名称：同一场站内应唯一
     */
    @NotBlank(message = "充电设备接口名称不能为空！")
    @JsonProperty("ConnectorName")
   @Schema(description = "充电设备接口名称：同一场站内应唯一")
    private String connectorName;

    /**
     * 充电设备接口类型：
     * 1：家用插座（模式 2） 2：交流接口插座（模 式 3，连接方式 B ）
     * 3：交流接口插头（带 枪线，模式 3，连接方 式 C） 4：直流接口枪头（带 枪线，模式 4） 5:无线充电座；
     */
    @NotNull
    @JsonProperty("ConnectorType")
   @Schema(description = "充电设备接口类型")
    private Integer connectorType;

    /**
     * 必填
     * 额定电压上限 单位：V
     */
    @NotNull
    @JsonProperty("VoltageUpperLimits")
   @Schema(description = "额定电压上限 单位：V")
    private Integer voltageUpperLimits;

    /**
     * 必填
     * 额定电压下限 单位：V
     */
    @NotNull
    @JsonProperty("VoltageLowerLimits")
   @Schema(description = "额定电压下限 单位：V")
    private Integer voltageLowerLimits;

    /**
     * 额定电流  单位：A
     */
    @JsonProperty("Current")
   @Schema(description = "额定电流  单位：A")
    private Integer current;

    /**
     * 额定功率  单位：KW
     */
    @JsonProperty("Power")
   @Schema(description = "额定功率  单位：KW")
    private Float power;

    /**
     * 车位号 停车场车位编号
     */
    @JsonProperty("ParkNo")
   @Schema(description = "车位号 停车场车位编号")
    private String parkNo;

    /**
     * 必填
     * 国家标准 1:2011 2:2015
     */
    @NotNull
    @JsonProperty("NationalStandard")
   @Schema(description = "国家标准 1:2011 2:2015")
    private Integer nationalStandard;
}