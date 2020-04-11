package com.base.design.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Location extends AuditDomain{
  Double lat;
  Double lng;
  String name;
  String city;
}
