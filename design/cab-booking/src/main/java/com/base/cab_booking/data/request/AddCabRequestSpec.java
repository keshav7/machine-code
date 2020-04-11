package com.base.cab_booking.data.request;

import com.base.cab_booking.enums.CabType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCabRequestSpec {

  String regNumber;
  CabType type;
  String createdBy;


}
