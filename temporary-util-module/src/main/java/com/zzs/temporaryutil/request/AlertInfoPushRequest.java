package com.zzs.temporaryutil.request;

import com.zzs.temporaryutil.po.AlarmInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 告警信息推送 请求参数
 *
 * @author zhuzs
 * @date 2022/8/11 11:36
 */
@Data
@Schema(description = "告警信息推送 请求参数")
public class AlertInfoPushRequest implements Serializable {
    private static final long serialVersionUID = 4887358999397477518L;

    /**
     * 站ID
     */
    @NotBlank(message = "站ID不能为空！")
    @Schema(description = "站ID")
    private String staId;

    /**
     * 充电设备告警信息
     */
    @Schema(description = "充电设备告警信息")
    @Valid
    @NotEmpty(message = "充电设备告警信息集合不能为空！")
    private List<AlarmInfo> alarmInfos;
}
