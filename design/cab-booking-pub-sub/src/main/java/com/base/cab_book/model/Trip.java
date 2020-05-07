package com.base.cab_book.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trip {


  String id;
  String src;
  String dest;
  String cabNum;
  String requestId;

  TripStatus status;
}
