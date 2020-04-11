package com.base.design.domain;

import com.base.design.enums.Currency;
import com.base.design.enums.TripStatus;
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
