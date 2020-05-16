package com.base.model;

public enum VehicleType {


  TWO_WHEELER,
  FOUR_WHEELER;


  public static VehicleType fromString(String inp) {

    if (inp == null) {
      return null;
    }

    for (VehicleType vehicleType : VehicleType.values()) {
      if (vehicleType.name().equals(inp)) {
        return vehicleType;
      }
    }
    return null;
  }

}
