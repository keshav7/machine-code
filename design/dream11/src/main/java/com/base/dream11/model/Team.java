package com.base.dream11.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

  String id;
  String user;
  List<String> players;
  Integer points = 0;
}
