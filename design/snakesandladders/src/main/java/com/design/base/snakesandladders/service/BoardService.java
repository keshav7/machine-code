package com.design.base.snakesandladders.service;

import com.design.base.snakesandladders.data.Move;
import com.design.base.snakesandladders.data.MoveType;
import com.design.base.snakesandladders.data.Player;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

@Service
@Data
public class BoardService {

  private Map<Integer, Integer> snakesMap;
  private Map<Integer, Integer> ladderMap;

  private List<Move> historyList;

  private Map<String, Integer> playerMap;
  Integer start;
  Integer end;

  public BoardService(List<Player> players) {

    snakesMap = new HashMap<>();
    ladderMap = new HashMap<>();

    snakesMap.put(23, 5);
    snakesMap.put(35, 12);
    snakesMap.put(54, 39);
    snakesMap.put(79, 25);
    snakesMap.put(94, 42);
    snakesMap.put(98, 48);

    ladderMap.put(19, 45);
    ladderMap.put(29, 61);
    ladderMap.put(33, 70);
    ladderMap.put(59, 91);
    ladderMap.put(77, 86);

    historyList = new ArrayList<>();

    start = 1;
    end = 100;
    playerMap = new HashMap<>();
    for (Player player : players) {
      playerMap.put(player.getName(), 0);
    }


  }

  @PostConstruct
  public void init() {


  }

  public void move(Player player, Integer dice) {

    Integer initialPosition = playerMap.get(player.getName());
    Integer newPosition = initialPosition + dice;
    historyList.add(populateMoveHistoryEntry(player, initialPosition, newPosition, MoveType.REGULAR));
    playerMap.put(player.getName(), newPosition);

    if (!hasWon(newPosition)) {
      Integer finalPosition;
      if (snakesMap.containsKey(newPosition)) {
        finalPosition = snakesMap.get(newPosition);
        historyList.add(populateMoveHistoryEntry(player, newPosition, finalPosition, MoveType.SNAKE_BITE));
        playerMap.put(player.getName(), finalPosition);
      }  else if (ladderMap.containsKey(newPosition)) {
        finalPosition = ladderMap.get(newPosition);
        historyList.add(populateMoveHistoryEntry(player, newPosition, finalPosition, MoveType.LADDER));
        playerMap.put(player.getName(), finalPosition);
      }
    }
  }

    private Move populateMoveHistoryEntry(Player player, Integer start, Integer end, MoveType type) {

    return new Move(player, start, end, type);
    }


  public Boolean hasWon(Integer position) {
    return position >= end;

  }

  public Boolean hasWon(Player player) {
    return hasWon(playerMap.get(player.getName()));

  }

  public void printMovesHistory() {

    for (Move move : historyList) {
      System.out.println(move.toString());
      System.out.println("\n");
    }
  }

}
