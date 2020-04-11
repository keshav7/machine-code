package com.base.design.core.exception;

import com.base.design.core.enums.Errors;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class BaseException extends Exception {

    private int errorStatusCode;
    private int errorInternalStatusCode;
    private String errorReasonCode;
    private String errorDescription;
    private HttpStatus status;
    private Map<String, String> additionalData;

    public BaseException(int errorStatusCode, int errorInternalStatusCode, String errorReasonCode,
                         String errorDescription, HttpStatus status) {
        this.errorStatusCode = errorStatusCode;
        this.errorInternalStatusCode = errorInternalStatusCode;
        this.errorReasonCode = errorReasonCode;
        this.errorDescription = errorDescription;
        this.status = status;
    }

    public BaseException(Errors errors, Exception e) {
        super(errors.getDescription());
        this.errorStatusCode = errors.getStatus().value();
        this.errorDescription = errors.getDescription();
        this.errorReasonCode = errors.getCode();
        this.status = errors.getStatus();
        this.errorInternalStatusCode = errors.getInternalErrorCode();
        this.addSuppressed(e);
    }


    public BaseException(Errors errors) {
        super(errors.getDescription());
        this.errorStatusCode = errors.getStatus().value();
        this.errorDescription = errors.getDescription();
        this.errorReasonCode = errors.getCode();
        this.status = errors.getStatus();
        this.errorInternalStatusCode = errors.getInternalErrorCode();
    }

    public BaseException(Errors errors, Map<String, String> additionalData) {
        super(errors.getDescription());
        this.errorStatusCode = errors.getStatus().value();
        this.errorDescription = errors.getDescription();
        this.errorReasonCode = errors.getCode();
        this.status = errors.getStatus();
        this.errorInternalStatusCode = errors.getInternalErrorCode();
        if (additionalData != null)
            this.additionalData = additionalData;
    }

    public BaseException(Errors errors, Map<String, String> additionalData, Exception e) {
        super(errors.getDescription());
        this.addSuppressed(e);
        this.errorStatusCode = errors.getStatus().value();
        this.errorDescription = errors.getDescription();
        this.errorReasonCode = errors.getCode();
        this.status = errors.getStatus();
        this.errorInternalStatusCode = errors.getInternalErrorCode();
        if (additionalData != null)
            this.additionalData = additionalData;
    }

}
