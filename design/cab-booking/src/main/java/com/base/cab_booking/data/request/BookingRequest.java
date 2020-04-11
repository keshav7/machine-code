package com.base.cab_booking.data.request;

import com.base.cab_booking.enums.CabType;
import com.base.cab_booking.domain.AuditDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest extends AuditDomain {

  String userId;
  CabType cabType;

}
