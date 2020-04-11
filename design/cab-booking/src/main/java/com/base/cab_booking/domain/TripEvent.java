package com.base.cab_booking.domain;

import com.base.cab_booking.enums.TripEventType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripEvent extends AuditDomain {

  TripEventType tripEventType;

}
