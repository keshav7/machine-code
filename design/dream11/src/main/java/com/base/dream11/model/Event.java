package com.base.dream11.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
  String id;
  EventType eventType;
  String player;
  String number;
}
