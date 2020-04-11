package com.base.cab_booking.domain;


import com.base.cab_booking.enums.CabType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cab extends AuditDomain {

  String regNumber;
  CabType type;

}
