package com.zzs.temporaryutil.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * 充电设备告警信息 实体
 *
 * @author zhuzs
 * @date 2022/9/19 09:15
 */
@Data
@JsonRootName("AlarmInfos")
@Schema(description = "充电设备告警信息 实体")
public class AlarmInfo implements Serializable {
    private static final long serialVersionUID = -6228250470432974865L;
    /**
     * 充电接口唯一编码
     * 对同一运营商，保证唯一
     */
    @JsonProperty(value = "ConnectorID")
    @Size(max = 23)
    @NotBlank(message = "充电设备接口编码不能为空！")
    @Schema(description = "充电设备接口编码")
    private String connectorId;

    /**
     * 告警时间
     * 格式为: yyyy-MM-dd HH:mm:ss
     */
    @JsonProperty(value = "Alert_time")
    @NotBlank(message = "告警时间不能为空！")
    @Schema(description = "告警时间")
    private String alertTime;

    /**
     * 告警代码
     * <p>
     * 充电设备故障信息
     * - 101 充电设备输入过压 102 充电设备输入过流 103 充电设备输出过压 104 充电设备输出过流 105 充电设备输出短路 106 充电设备输出反接
     * 107 充电设备过温 108 充电设备缺相保护 109 充电设备浪涌保护 110 充电设备模块故障 111 充电设备风扇故障 112 充电设备急停故障
     * 113 充电设备读卡器故障 114 充电设备电表故障 115 充电设备液晶故障 116 充电设备绝缘故障 117 充电设备连接器故障 118 BMS 通信故障
     * 119 充电桩接地故障 120~200 预留 201 电动汽车动力电池组过压 202 电动汽车动力电池组欠压
     * <p>
     * BMS 故障信息
     * - 201 电动汽车动力电池组过压 202 电动汽车动力电池组欠压  203 电动汽车动力电池组过流 204 电动汽车动力电池组过温
     * 205 电动汽车动力电池组绝缘故障 206~300 预留
     */
    @JsonProperty(value = "Alert_code")
    @Schema(description = "告警代码")
    private Integer alertCode;

    /**
     * 描述
     * 文字描述，最大长度 256 字符
     */
    @JsonProperty(value = "Describe")
    @NotNull
    @Size(max = 256)
    @Schema(description = "描述")
    private String describe;

    /**
     * 状态 告警发生: 0 ,告警恢复: 1 ,默认为 0。
     */
    @JsonProperty(value = "Status")
    @NotNull
    @Schema(description = "状态")
    private Integer status;
}
