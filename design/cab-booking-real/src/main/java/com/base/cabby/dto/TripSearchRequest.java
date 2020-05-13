package com.base.cabby.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TripSearchRequest {

  String tripId;
  String status;
  String cabReqNum;
  String requestId;



}
