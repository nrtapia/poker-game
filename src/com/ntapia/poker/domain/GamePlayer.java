package com.ntapia.poker.domain;

import com.ntapia.poker.application.ChipManager;
import com.ntapia.poker.application.GameManager;
import com.ntapia.poker.application.PlayerManager;
import com.ntapia.poker.application.ScoreManager;
import com.ntapia.poker.domain.score.Score;

public class GamePlayer {

  public static void main(String[] args) {

    ScoreManager scoreManager = new ScoreManager();
    ChipManager chipManager = new ChipManager();
    PlayerManager playerManager = new PlayerManager();

    playerManager.register("AlPHA", chipManager.buildBaseChipsForPlayer());
    playerManager.register("BRAVO", chipManager.buildBaseChipsForPlayer());
    playerManager.register("CHARLIE", chipManager.buildBaseChipsForPlayer());

    GameManager gameManager = new GameManager(playerManager, scoreManager);
    gameManager.start();
    gameManager.display();

    Score score = gameManager.evaluateWinner();
    System.out.printf("%n-- Score -- %n Player: %s%n Hand: %s%n Chips: %s",
        score.getPlayerName(), score.getWinnerHand(), score.getEarnedPot());
  }
}
