package com.base.design.data.request;

import com.base.design.domain.AuditDomain;
import com.base.design.enums.CabType;
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
