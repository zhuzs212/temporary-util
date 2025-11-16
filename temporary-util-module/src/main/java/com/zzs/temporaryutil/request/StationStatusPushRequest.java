package com.zzs.temporaryutil.request;

import com.zzs.temporaryutil.po.ChargeStatusInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

/**
 * 设备状态变化推送 请求参数
 *
 * @author zhuzs
 * @date 2022/8/11 11:25
 */
@Data
@Schema(description = "设备状态变化推送请求参数")
public class StationStatusPushRequest implements Serializable {
    private static final long serialVersionUID = 8463385640760537423L;

    /**
     * 站ID
     */
    @NotBlank(message = "站ID不能为空！")
    @Schema(description = "站ID")
    private String staId;

    /**
     * 设备状态变信息
     */
    @Schema(description = "设备状态变信息")
    @Valid
    private ChargeStatusInfo chargeStatusInfo;
}
