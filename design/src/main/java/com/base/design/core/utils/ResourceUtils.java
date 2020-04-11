package com.base.design.core.utils;

import com.base.design.core.exception.BaseException;
import com.base.design.core.response.ClientResponse;
import com.base.design.core.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

/**
 * Created by ankush.a on 29/06/17.
 */
@Slf4j
public class ResourceUtils {

    public static ClientResponse setClientErrorResponse(BaseException e) {
        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setSuccess(false);
        ErrorResponse errorResponse = new ErrorResponse(e);
        clientResponse.setErrorResponse(errorResponse);
        clientResponse.setHttpStatus(HttpStatus.valueOf(errorResponse.getErrorStatusCode()));
        return clientResponse;
    }
}
