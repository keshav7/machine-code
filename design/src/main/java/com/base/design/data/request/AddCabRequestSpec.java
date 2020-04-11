package com.base.design.data.request;

import com.base.design.enums.CabType;
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
