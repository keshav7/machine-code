package com.base.cabby.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CabRequest {

  String id;
  String userId;
  String src;
  String dest;
  private CabType cabType;


}
