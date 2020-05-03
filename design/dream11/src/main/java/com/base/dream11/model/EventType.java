package com.base.dream11.model;

public enum EventType {
  CATCH,
  RUN,
  WICKET;


  public static EventType fromString(String type) {

    if (type == null) {
      return null;
    }
    for (EventType eventType : EventType.values()) {
      if (eventType.name().equals(type)) {
        return eventType;
      }
    }
    return null;
  }
}
