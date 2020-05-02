package com.base.splitwise.model.enums;

public enum SplitType {
  EXACT,
  PERCENT,
  EQUAL;

  public static SplitType fromString(String input) {
    if (input == null) {
      return null;
    }

    for (SplitType value : SplitType.values()) {
      if (value.name().equalsIgnoreCase(input)) {
        return value;
      }
    }

    return null;
  }



}
