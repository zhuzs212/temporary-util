package com.zzs.temporaryutil.constans;

public class BaseException extends RuntimeException {
    private final ErrorType errorType;

    public BaseException() {
        this.errorType = SystemErrorType.SYSTEM_ERROR;
    }

    public BaseException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public BaseException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public BaseException(ErrorType errorType, String message, Throwable cause) {
        super(message, cause);
        this.errorType = errorType;
    }

    public BaseException(String message) {
        super(message);
        this.errorType = SystemErrorType.SYSTEM_ERROR;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }
}