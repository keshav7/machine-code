package com.base.cab_book.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Request {

  String id;
  String userId;
  Long createdAt;
  CabType cabType;
  String src;
  String dest;
}
