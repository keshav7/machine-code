package com.base.cab_book.model;

public enum TripStatus {

  CREATED,
  STARTED,
  COMPLETED,
  CANCELLED,
  ABORTED;



  public static TripStatus fromString(String trip) {
    if (trip == null) {
      return null;
    }

    for (TripStatus status : TripStatus.values()) {
      if (status.name().equals(trip)) {
        return status;
      }
    }

    return null;

  }
}
