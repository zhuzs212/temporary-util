package com.zzs.temporaryutil.constans;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@Schema
public class Result<T> {
    public static final Long SUCCESSFUL_CODE = 0L;
    public static final String SUCCESSFUL_MESG = "处理成功";
    @Schema(description = "处理结果code", required = true)
    private Long code;
    @Schema(description = "处理结果描述信息")
    private String message;
    @Schema(description = "请求结果生成时间戳")
    private Long time;
    @Schema(description = "处理结果数据信息")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Result() {
        this.time = LocalDateTime
                .now()
                .atZone(ZoneId.systemDefault())  // 使用系统默认时区
                .toInstant()
                .toEpochMilli();
    }

    public Result(ErrorType errorType) {
        this.code = errorType.getCode();
        this.message = errorType.getMesg();
        this.time = LocalDateTime
                .now()
                .atZone(ZoneId.systemDefault())  // 使用系统默认时区
                .toInstant()
                .toEpochMilli();
    }

    public Result(ErrorType errorType, T data) {
        this(errorType);
        this.data = data;
    }

    private Result(Long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.time = LocalDateTime
                .now()
                .atZone(ZoneId.systemDefault())  // 使用系统默认时区
                .toInstant()
                .toEpochMilli();
    }



    public static Result success(Object data) {
        return new Result(SUCCESSFUL_CODE, "处理成功", data);
    }

    public static Result success(String mesg, Object data) {
        return new Result(SUCCESSFUL_CODE, mesg, data);
    }

    public static Result success() {
        return success((Object)null);
    }

    public static Result fail() {
        return new Result(SystemErrorType.SYSTEM_ERROR);
    }

    public static Result fail(BaseException baseException) {
        return fail((BaseException)baseException, (Object)null);
    }

    public static Result fail(BaseException baseException, Object data) {
        return new Result(baseException.getErrorType(), data);
    }

    public static Result fail(ErrorType errorType, Object data) {
        return new Result(errorType, data);
    }

    public static Result fail(ErrorType errorType) {
        return fail((ErrorType)errorType, (Object)null);
    }

    public static Result fail(Long code, String message, Object data) {
        return new Result(code, message, data);
    }

    public static Result fail(Object data) {
        return new Result(SystemErrorType.SYSTEM_ERROR, data);
    }
}