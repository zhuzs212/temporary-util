package com.zzs.temporaryutil.constans;

public enum SystemErrorType implements ErrorType {
    SYSTEM_ERROR(-1L, "系统异常"),
    SYSTEM_BUSY(1L, "系统繁忙,请稍候再试"),
    GATEWAY_NOT_FOUND_SERVICE(10404L, "服务未找到"),
    GATEWAY_ERROR(10500L, "网关异常"),
    GATEWAY_CONNECT_TIME_OUT(1002L, "网关超时"),
    ARGUMENT_NOT_VALID(20000L, "请求参数校验不通过"),
    UPLOAD_FILE_SIZE_LIMIT(20001L, "上传文件大小超过限制"),
    UPLOAD_FILE_FORMAT_ERROR(20002L, "上传文件格式错误"),
    UPLOAD_FILE_NULL(20003L, "上传文件数据为空"),
    DUPLICATE_PRIMARY_KEY(30000L, "唯一键冲突"),
    DEL_EXIST_VALID(40000L, "存在下级,不能删除"),
    ADD_FAIL(50000L, "新增失败"),
    UPDATE_FAIL(60000L, "修改失败"),
    DELETE_FAIL(70000L, "删除失败"),
    USED_BEFORE_DELETE_FAIL(80000L, "已被使用不能删除"),
    USER_USERNAME_REPEAT(10000L, "用户username重复"),
    USER_EMAIL_NOT_VALID(10001L, "邮箱格式校验不通过"),
    USER_ADD_FAIL(10002L, "用户新增失败"),
    USER_UPDATE_FAIL(10003L, "用户修改失败"),
    ORG_DEL_EXIST_VALID(10004L, "组织机构下存在下级机构不能删除"),
    ORG_DEL_USER_VALID(10005L, "组织机构下存在关联用户不能删除"),
    NULL_ASSET_NO(20001L, "未上传资产编号"),
    NULL_UP_ASSET_NO(20003L, "上传资产编号文件为空"),
    ERROR_UP_ASSET_NO(20004L, "上传资产编号失败"),
    ASSET_NO_SIZE_LIMIT(20002L, "资产编号数量不足"),
    START_FAIL(40001L, "启动失败"),
    STOP_FAIL(40002L, "停止失败"),
    QUERY_FAIL(40003L, "获取信息失败");



    private Long code;
    private String message;

    SystemErrorType(Long code, String message) {
        this.code = code;
        this.message = message;
    }

//    @Override
    public Long getCode() {
        return this.code;
    }

//    @Override
    public String getMesg() {
        return this.message;
    }
}