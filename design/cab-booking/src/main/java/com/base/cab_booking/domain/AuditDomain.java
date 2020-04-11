package com.base.cab_booking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditDomain {

  String createdBy;
  String updatedBy;
  Long createdAt;
  Long updatedAt;
}
