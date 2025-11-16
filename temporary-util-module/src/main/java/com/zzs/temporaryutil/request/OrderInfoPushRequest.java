package com.zzs.temporaryutil.request;

import com.zzs.temporaryutil.po.OrderInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

/**
 * 订单信息推送 请求参数
 *
 * @author zhuzs
 * @date 2022/8/11 11:36
 */
@Data
@Schema(description = "订单信息推送请求参数")
public class OrderInfoPushRequest implements Serializable {
    private static final long serialVersionUID = 4887358999397477518L;

    /**
     * 站ID
     */
    @NotBlank(message = "站ID不能为空！")
    @Schema(description = "站ID")
    private String staId;

    /**
     * 订单信息
     */
    @Schema(description = "订单信息")
    @Valid
    private OrderInfo orderInfo;
}
