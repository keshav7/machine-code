package com.base.model;

public enum SpotType {
  TWO_WHEELER,
  FOUR_WHEELER,
  TRUCK;


  public static SpotType fromString(String inp) {

    if (inp == null) {
      return null;
    }

    for (SpotType spotType : SpotType.values()) {
      if (spotType.name().equals(inp)) {
        return spotType;
      }
    }
    return null;
  }
}
