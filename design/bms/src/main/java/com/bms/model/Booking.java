package com.bms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
  String id;
  String userId;
  Long createdTimeStamp;

  // can add payment related info also
}
