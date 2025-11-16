package com.zzs.temporaryutil.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 充电设备信息
 *
 * @author zhuzs
 * @date 2022/8/2 10:39
 */
@Data
@JsonRootName("EquipmentInfo")
@ApiModel("充电设备信息")
public class EquipmentInfo implements Serializable {
    private static final long serialVersionUID = 8719786492394405492L;
    /**
     * 必填
     * 设备编码：设备唯一编码，对同一 运营商，保证唯一
     */
    @NotBlank(message = "设备编码不能为空！")
    @JsonProperty("EquipmentID")
    @ApiModelProperty("设备编码：设备唯一编码，对同一 运营商，保证唯一")
    private String equipmentId;

    /**
     * 设备生产商 组织机构代码：设备生产商组织机构代 码如果填写需要与铭牌上 保持一致
     */
    @JsonProperty("ManufacturerID")
    @ApiModelProperty("设备生产商 组织机构代码：设备生产商组织机构代 码如果填写需要与铭牌上 保持一致")
    private String manufacturerId;

    /**
     * 设备生产商名称: 设备生产商名称 如果填写需要与铭牌上 保持一致
     */
    @JsonProperty("ManufacturerName")
    @ApiModelProperty("设备生产商名称: 设备生产商名称 如果填写需要与铭牌上 保持一致")
    private String manufacturerName;

    /**
     * 设备型号: 由设备生厂商定义的设备型号 如果填写需要与铭牌上保持一致
     */
    @JsonProperty("EquipmentModel")
    @ApiModelProperty("设备型号: 由设备生厂商定义的设备型号 如果填写需要与铭牌上保持一致")
    private String equipmentModel;

    /**
     * 必填
     * 设备名称：充电设备名称，同一场站内应唯一
     */
    @NotBlank(message = "设备名称不能为空！")
    @JsonProperty("EquipmentName")
    @ApiModelProperty("设备名称：充电设备名称，同一场站内应唯一")
    private String equipmentName;

    /**
     * 设备生产日期 yyyy-MM-dd
     */
    @JsonProperty("ProductionDate")
    @ApiModelProperty("设备生产日期 yyyy-MM-dd")
    private String productionDate;

    /**
     * 必填
     * 投运日期 yyyy-MM-dd
     */
//    @JsonInclude(JsonInclude.Include.NON_NULL)//NULL时不序列化
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @NotBlank(message = "投运日期不能为空！")
    @JsonProperty("OpenForBusinessDate")
    @ApiModelProperty("投运日期 yyyy-MM-dd")
    private String openForBusinessDate;

    /**
     * 必填
     * 设备类型: 1：直流设备 2：交流设备 3：交直流一体设备
     */
    @NotNull
    @JsonProperty("EquipmentType")
    @ApiModelProperty("设备类型: 1：直流设备 2：交流设备 3：交直流一体设备")
    private Integer equipmentType;

    /**
     * 必填
     * 设备状态：0：未知 1：建设中 5：关闭下线 6：维护中 50：正常使用
     */
    @NotNull
    @JsonProperty("EquipmentStatus")
    @ApiModelProperty("设备状态：0：未知 1：建设中 5：关闭下线 6：维护中 50：正常使用")
    private Integer equipmentStatus;

    /**
     * 必填
     * 额定功率 单位：kW
     */
    @NotNull
    @JsonProperty("Power")
    @ApiModelProperty("额定功率 单位：kW")
    private Float power;

    /**
     * 必填
     * 充电设备接口列表：该充电设备所有的充电 设备接口的信息对象集合
     */
    @NotEmpty
    @JsonProperty("ConnectorInfos")
    @ApiModelProperty("充电设备接口列表：该充电设备所有的充电 设备接口的信息对象集合")
    private List<ConnectorInfo> connectorInfos;

    /**
     * 充电设备经度
     */
    @JsonProperty("EquipmentLng")
    @ApiModelProperty("充电设备经度")
//    @JsonSerialize(using = Double6Serialize.class)
    private Double equipmentLng;

    /**
     * 充电设备纬度
     */
    @JsonProperty("EquipmentLat")
    @ApiModelProperty("充电设备纬度")
//    @JsonSerialize(using = Double6Serialize.class)
    private Double equipmentLat;
}