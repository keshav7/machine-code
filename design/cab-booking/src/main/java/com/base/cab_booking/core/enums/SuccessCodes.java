package com.base.cab_booking.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by ankush.a on 05/12/17.
 */
@AllArgsConstructor
public enum SuccessCodes {

    CREATED("CREATED", "Created"),
    SUCCESSFULLY_UPDATED("SUCCESSFULLY_UPDATED", "Updated"),
    SUCCESSFULLY_ADDED("SUCCESSFULLY_ADDED", "Added"),
    DELETED("DELETED","Deleted"),
    OK("OK","Ok");

    @Getter
    private String code;
    @Getter
    private String description;


}
