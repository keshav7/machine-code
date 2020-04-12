package com.base.foodprocessor.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
  Map<String, Double> itemIdPriceMap;
  Integer capacity;
  String name;
}
