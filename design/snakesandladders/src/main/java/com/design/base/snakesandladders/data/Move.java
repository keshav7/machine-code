package com.design.base.snakesandladders.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Move {

  Player player;
  Integer from;
  Integer to;
  MoveType type;

}
