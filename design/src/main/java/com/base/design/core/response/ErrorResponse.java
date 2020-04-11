package com.base.design.core.response;

import com.base.design.core.enums.Errors;
import com.base.design.core.exception.BaseException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Created by ankush.a on 04/06/17.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {

    private int errorStatusCode;
    private int errorInternalStatusCode;
    private String errorReasonCode;
    private String errorDescription;
    private Map<String, String> additionalData;


    public ErrorResponse(BaseException e) {
        this.errorStatusCode = e.getErrorStatusCode();
        this.errorReasonCode = e.getErrorReasonCode();
        this.errorDescription = e.getErrorDescription();
        this.errorInternalStatusCode = e.getErrorInternalStatusCode();
        if (e.getAdditionalData() != null)
            this.additionalData = e.getAdditionalData();
    }

    public ErrorResponse(Errors errors) {
        this.errorStatusCode = errors.getStatus().value();
        this.errorReasonCode = errors.getCode();
        this.errorDescription = errors.getDescription();
        this.errorInternalStatusCode = errors.getInternalErrorCode();
    }
}
