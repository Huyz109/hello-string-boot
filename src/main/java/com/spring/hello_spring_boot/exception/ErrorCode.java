package com.spring.hello_spring_boot.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),
    USER_EXISTED(1002, "User existed"),
    USER_NOT_EXISTED(1003, "User not existed"),
    UNAUTHENTICATED(1004, "Unauthenticated"),
    UNAUTHORIZED(1005, "You do not have permission"),
    ;
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
