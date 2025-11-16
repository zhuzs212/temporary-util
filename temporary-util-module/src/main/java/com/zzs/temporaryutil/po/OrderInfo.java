package com.zzs.temporaryutil.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单信息 实体
 *
 * @author zhuzs
 * @date 2022/7/26 14:12
 */
@Data
@JsonRootName("OrderInfo")
@Schema(description = "订单信息 实体")
public class OrderInfo implements Serializable {
    private static final long serialVersionUID = -9018859299564124115L;

    /**
     * 运营商 ID
     * 组织机构代码
     */
    @JsonProperty("OperatorID")
   @Schema(description = "运营商 ID")
    private String operatorID;

    /**
     * 充电设备接口编码
     * 充电设备接口编码，同一充电运营商平台内唯一
     */
    @JsonProperty("ConnectorID")
    @NotBlank(message = "充电设备接口编码不能为空！")
   @Schema(description = "充电设备接口编码")
    private String connectorID;

    /**
     * 充电订单号
     * 运营商充电订单号
     */
    @JsonProperty("StartChargeSeq")
    @NotBlank(message = "充电订单号不能为空！")
   @Schema(description = "充电订单号")
    private String startChargeSeq;

    /**
     * 用户发起充电类型
     * 1:充电运营商平台注册用户
     * 2:监管平台注册用户
     * 3:其他
     */
    @JsonProperty("UserChargeType")
    @NotNull
   @Schema(description = "用户发起充电类型 1:充电运营商平台注册用户;2:监管平台注册用户;3:其他")
    private Integer userChargeType;

    /**
     * 非必填 推荐接入
     * 用户手机号 若用户发起充电类型为APP，用户手机号必填
     */
    @JsonProperty("MobileNumber")
   @Schema(description = "用户手机号 若用户发起充电类型为APP，用户手机号必填")
    private String mobileNumber;

    /**
     * 本次充电消费总金额 单位：元，保留小数点后2位
     */
    @JsonProperty("Money")
    @NotNull
   @Schema(description = "本次充电消费总金额 单位：元，保留小数点后2位")
    private BigDecimal money;

    /**
     * 本次充电电费总金额 单位：元，保留小数点后三位
     */
    @JsonProperty("ElectMoney")
    @NotNull
   @Schema(description = "本次充电电费总金额 单位：元，保留小数点后三位")
    private BigDecimal electMoney;

    /**
     * 本次充电服务费金额 单位：元，保留小数点后三位
     */
    @JsonProperty("ServiceMoney")
    @NotNull
   @Schema(description = "本次充电服务费金额 单位：元，保留小数点后三位")
    private BigDecimal serviceMoney;

    /**
     * 本次充电电量 单位 kWh，精度 0.001
     */
    @JsonProperty("Elect")
    @NotNull
   @Schema(description = "本次充电电量 单位 kWh，精度 0.001")
    private BigDecimal elect;

    /**
     * 尖阶段电量 单位 kWh，精度 0.001
     */
    @JsonProperty("CuspElect")
    @NotNull
   @Schema(description = "尖阶段电量 单位 kWh，精度 0.001")
    private BigDecimal cuspElect;

    /**
     * 峰阶段电量 单位 kWh，精度 0.001
     */
    @JsonProperty("PeakElect")
    @NotNull
   @Schema(description = "峰阶段电量 单位 kWh，精度 0.001")
    private BigDecimal peakElect;

    /**
     * 平阶段电量 单位 kWh，精度 0.001
     */
    @JsonProperty("FlatElect")
    @NotNull
   @Schema(description = "平阶段电量 单位 kWh，精度 0.001")
    private BigDecimal flatElect;

    /**
     * 谷阶段电量 单位 kWh，精度 0.001
     */
    @JsonProperty("ValleyElect")
    @NotNull
   @Schema(description = "谷阶段电量 单位 kWh，精度 0.001")
    private BigDecimal valleyElect;

    /**
     * 本次充电开始时间 yyyy-MM-dd HH:mm:ss
     */
    @JsonProperty("StartTime")
    @NotBlank(message = "本次充电开始时间不能为空！")
   @Schema(description = "本次充电开始时间 yyyy-MM-dd HH:mm:ss")
    private String startTime;

    /**
     * 本次充电结束时间 yyyy-MM-dd HH:mm:ss
     */
    @JsonProperty("EndTime")
    @NotBlank(message = "本次充电结束时间不能为空！")
   @Schema(description = "本次充电结束时间 yyyy-MM-dd HH:mm:ss")
    private String endTime;

    /**
     * 非必填
     * 支付金额 保留小数点后 2 位
     */
    @JsonProperty("PaymentAmount")
   @Schema(description = "支付金额 保留小数点后 2 位")
    private BigDecimal paymentAmount;

    /**
     * 电表总起值 单位 kWh，精度 0.001
     */
    @JsonProperty("MeterValueStart")
    @NotNull
   @Schema(description = "电表总起值 单位 kWh，精度 0.001")
    private BigDecimal meterValueStart;

    /**
     * 电表总止值 单位 kWh，精度 0.001
     */
    @JsonProperty("MeterValueEnd")
    @NotNull
   @Schema(description = "电表总止值 单位 kWh，精度 0.001")
    private BigDecimal meterValueEnd;
}
