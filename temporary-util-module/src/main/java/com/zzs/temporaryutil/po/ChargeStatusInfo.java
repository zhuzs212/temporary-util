package com.zzs.temporaryutil.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * 设备状态变化推送 数据实体
 *
 * @author zhuzs
 * @date 2022/7/14 19:19
 */
@Data
@JsonRootName("ConnectorStatusInfo")
@Schema(description = "设备状态变化推送 数据实体")
public class ChargeStatusInfo implements Serializable {
	private static final long serialVersionUID = -7179475701047407851L;
	/**
     * 必填
     * 充电设备接口编码：充电设备接口编码，同一运营商内唯一
     */
	@JsonProperty(value = "ConnectorID")
	@NotBlank(message = "充电设备接口编码不能为空！")
    private String connectorId;
    /**
     * 必填
     * 充电设备接口状态：
     * 0：离网
     * 1：空闲
     * 2：占用（未充电）
     * 3：占用（充电中）
     * 4：占用（预约锁定）
     * 255：故障
     */
	@JsonProperty(value = "Status")
	@NotNull
	@Schema(description = "充电设备接口状态：0：离网;1：空闲;2：占用-未充电;3：占用-充电中;4：占用-预约锁定;255：故障")
    private Integer status;
    /**
     * 必填
     * A相电流 单位：A，默认：0 含直流(输出)
     */
	@JsonProperty(value = "CurrentA")
	@NotNull
	@Schema(description = "A相电流 单位：A，默认：0 含直流 输出")
    private Float currentA;
    /**
     * 必填
     * A相电压 单位：V，默认：0
     */
	@JsonProperty(value = "VoltageA")
	@NotNull
	@Schema(description = "A相电压 单位：V，默认：0")
    private Float voltageA;
	/**
	 * 必填
	 * 剩余电量 默认：0 交流充电桩采集不到SOC值的填0
	 * 保留小数点后一位
	 */
	@JsonProperty(value = "SOC")
	@NotNull
	@Schema(description = "剩余电量 默认：0 交流充电桩采集不到SOC值的填0 保留小数点后一位")
	private Float soc;
	/**
	 * 必填
	 * 开始充电时间 格式为yyyy-MM-dd HH:mm:ss
	 */
	@JsonProperty(value = "Begin_time")
	@NotNull
	@Schema(description = "开始充电时间 格式为yyyy-MM-dd HH:mm:ss")
	private String beginTime;
    /**
     * 必填
     * 本次已充电量 单位：kWh 保留小数点后三位
     */
	@JsonProperty(value = "Current_kwh")
	@NotNull
	@Schema(description = "本次已充电量 单位：kWh 保留小数点后三位")
    private Float currentKwh;
    /**
     * 必填
     * 时间戳 数据生成时间（秒级时间戳）
     */
	@JsonProperty(value = "Time_stamp")
	@NotNull
	@Schema(description = "时间戳 数据生成时间 秒级时间戳")
    private Long timeStamp;

}