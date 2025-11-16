package com.zzs.temporaryutil.fegin;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.zzs.temporaryutil.constans.Result;
import com.zzs.temporaryutil.fallback.MessagePushFallBackFactory;
import com.zzs.temporaryutil.request.AlertInfoPushRequest;
import com.zzs.temporaryutil.request.ModifyStationInfoRequest;
import com.zzs.temporaryutil.request.OrderInfoPushRequest;
import com.zzs.temporaryutil.request.StationStatusPushRequest;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 互联互通数据推送 Feign接口
 *
 * @author zhuzs
 * @date 2022/8/5 14:05
 */
@Component
@FeignClient(name = "temporary-util-service", path = "/temporaryUtil", fallbackFactory = MessagePushFallBackFactory.class)
public interface TemporaryUtil {

    /**
     * 充电站信息变化推送
     *
     * @throws Exception
     */
    @PostMapping(value = "/updateStationInfo")
    Result modifyStationInfo(@RequestBody @Valid ModifyStationInfoRequest request) throws JsonProcessingException;

    /**
     * 设备状态变化推送
     *
     * @throws Exception
     */
    @PostMapping(value = "/stationStatusPush")
    Result stationStatusPush(@RequestBody @Valid StationStatusPushRequest request) throws JsonProcessingException;

    /**
     * 订单信息推送
     *
     * @throws Exception
     */
    @PostMapping(value = "/orderInfoPush")
    Result orderInfoPush(@RequestBody @Valid OrderInfoPushRequest request) throws JsonProcessingException;

    /**
     * 告警信息推送
     *
     * @throws Exception
     */
    @PostMapping(value = "/alertInfoPush")
    Result alertInfoPush(@Valid @RequestBody AlertInfoPushRequest request) throws JsonProcessingException;

    /**
     * 发送注册验证码
     *
     * @param emailAddress
     * @return
     */
    @GetMapping(value = "/sendEmail")
    Result sendEmail(@RequestParam("emailAddress") String emailAddress) throws Exception;
}