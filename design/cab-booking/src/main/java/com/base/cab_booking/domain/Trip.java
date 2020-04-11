package com.base.cab_booking.domain;

import com.base.cab_booking.enums.Currency;
import com.base.cab_booking.enums.TripStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip extends AuditDomain {

  String id;
  TripStatus status;
  Currency currency;
  Double estimateFare;
  Double actualFare;

}
