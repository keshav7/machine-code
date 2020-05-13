package com.base.cabby.model;

public enum TripStatus {
  CREATED,
  COMPLETED,
  CANCELLED;


  public static TripStatus fromString(String status) {
    if (status == null) {
      return null;
    }

    for (TripStatus tripStatus : TripStatus.values()) {
      if (tripStatus.name().equals(status)) {
        return tripStatus;
      }
    }
    return null;

  }
}
