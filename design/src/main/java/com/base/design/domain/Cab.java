package com.base.design.domain;


import com.base.design.enums.CabType;
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
