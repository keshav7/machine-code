package com.base.design.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum Errors {

    BS_INTERNAL_ERROR("INTERNAL_ERROR", 1401, HttpStatus.INTERNAL_SERVER_ERROR, "Internal Error"),
    BS_BAD_REQUEST("BAD_REQUEST", 1402, HttpStatus.BAD_REQUEST, "Bad Request");

    @Getter
    private String code;
    @Getter
    private int internalErrorCode;
    @Getter
    private HttpStatus status;
    @Getter
    private String description;
}
