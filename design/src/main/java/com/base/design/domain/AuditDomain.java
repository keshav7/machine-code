package com.base.design.domain;

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
