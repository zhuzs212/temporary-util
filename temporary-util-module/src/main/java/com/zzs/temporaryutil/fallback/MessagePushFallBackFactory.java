package com.zzs.temporaryutil.fallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zzs.temporaryutil.constans.Result;
import com.zzs.temporaryutil.constans.SystemErrorType;
import com.zzs.temporaryutil.fegin.TemporaryUtil;
import com.zzs.temporaryutil.request.AlertInfoPushRequest;
import com.zzs.temporaryutil.request.ModifyStationInfoRequest;
import com.zzs.temporaryutil.request.OrderInfoPushRequest;
import com.zzs.temporaryutil.request.StationStatusPushRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 降级处理逻辑
 *
 * @author zhuzs
 * @date 2022/8/17 18:26
 */
@Component
@Slf4j
public class MessagePushFallBackFactory implements FallbackFactory<TemporaryUtil> {

    @Override
    public TemporaryUtil create(Throwable cause) {
        log.error("MessagePushFeign 服务调用异常,message:{},throwable:{}", cause.getMessage(), cause);
        return new TemporaryUtil() {
            @Override
            public Result modifyStationInfo(ModifyStationInfoRequest request) throws JsonProcessingException {
                return Result.fail(SystemErrorType.SYSTEM_ERROR.getCode(), "充电站信息变化推送接口请求失败，请稍后重试！cause: " + cause.getMessage(), null);
            }

            @Override
            public Result stationStatusPush(StationStatusPushRequest request) throws JsonProcessingException {
                return Result.fail(SystemErrorType.SYSTEM_ERROR.getCode(), "设备状态变化推送接口请求失败，请稍后重试！cause: " + cause.getMessage(), null);
            }

            @Override
            public Result orderInfoPush(OrderInfoPushRequest request) throws JsonProcessingException {
                return Result.fail(SystemErrorType.SYSTEM_ERROR.getCode(), "订单信息推送接口请求失败，请稍后重试！cause: " + cause.getMessage(), null);
            }

            @Override
            public Result alertInfoPush(AlertInfoPushRequest request) throws JsonProcessingException {
                return Result.fail(SystemErrorType.SYSTEM_ERROR.getCode(), "告警信息推送接口请求失败，请稍后重试！cause: " + cause.getMessage(), null);
            }

            @Override
            public Result sendEmail(String emailAddress) {
                return Result.fail(SystemErrorType.SYSTEM_ERROR.getCode(), "发送注册验证码接口请求失败，请稍后重试！cause: " + cause.getMessage(), null);
            }
        };
    }
}
