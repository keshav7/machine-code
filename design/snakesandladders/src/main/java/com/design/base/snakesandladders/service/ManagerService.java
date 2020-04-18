package com.design.base.snakesandladders.service;

import com.design.base.snakesandladders.data.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ManagerService {


  public void play() {

    List<Player> playersList = new ArrayList<>();
    playersList.add(new Player("A"));
    playersList.add(new Player("B"));

    BoardService boardService = new BoardService(playersList);

    int turn = 1;

    Player player;
    while (turn < 100) {

      player = playersList.get(turn % playersList.size());

      boardService.move(player, rollDice());

      if (boardService.hasWon(player)) {
        System.out.println(player.getName() + " has Won");
        break;
      }

      turn++;
    }

    boardService.printMovesHistory();


  }

  private int rollDice() {
    return new Random().nextInt(5) + 1;
  }



}
