package com.zzs.temporaryutil.request;

import com.zzs.temporaryutil.po.StationInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

/**
 * 充电站信息变化推送接口 请求参数
 * @author zhuzs
 * @date 2022/8/4 16:15
 */
@Data
@Schema(description = "充电站信息变化推送接口请求参数")
public class ModifyStationInfoRequest implements Serializable {
    private static final long serialVersionUID = -7532288464067341534L;

    /**
     * 站ID
     */
    @NotBlank(message = "站ID不能为空！")
    @Schema(description = "站ID")
    private String staId;

    /**
     * 充电站信息
     */
    @Schema(description = "充电站信息")
    @Valid
    private StationInfo stationInfo;
}
