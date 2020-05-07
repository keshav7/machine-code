package com.base.cab_book.model;

public enum CabType {
  SEDAN,
  SUV,
  COMPACT;



  public static CabType fromString(String cab) {

    if (cab == null) {
      return null;
    }

    for(CabType  cabType: CabType.values()) {
      if (cabType.name().equals(cab)) {
        return cabType;
      }
    }
    return null;
  }
}
