package com.base.design.domain;

import com.base.design.enums.TripEventType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripEvent extends AuditDomain {

  TripEventType tripEventType;

}
