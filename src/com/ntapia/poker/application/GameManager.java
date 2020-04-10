package com.ntapia.poker.application;

import com.ntapia.poker.domain.chip.Chip;
import com.ntapia.poker.domain.game.Game;
import com.ntapia.poker.domain.player.PlayerWithoutFoundsException;
import com.ntapia.poker.domain.score.Score;
import java.util.List;
import java.util.Random;

public class GameManager {

  private static final int DEFAULT_ANTE = 1;

  private final Game game;
  private final PlayerManager playerManager;
  private final ScoreManager scoreManager;
  private final ChipManager chipManager;
  private Random random = new Random();

  public GameManager(PlayerManager playerManager,
      ScoreManager scoreManager) {
    this.playerManager = playerManager;
    this.scoreManager = scoreManager;
    this.chipManager = new ChipManager();
    this.game = new Game(playerManager.getNames());
  }

  public void start() {
    shuffle();
    initialDeal();
    requireAnte();
  }

  private void initialDeal() {
    game.initialDeal();
  }

  private void shuffle() {
    game.shuffleCards();
  }

  public Score evaluateWinner() {
    final String playerName = getRandomPlayerName();

    final List<Chip> chips = chipManager.claimPot(playerName);
    final Score score = new Score(playerName, game.getPlayerHand(playerName), chips);
    scoreManager.addScore(score);

    return score;
  }

  private String getRandomPlayerName() {
    List<String> names = this.playerManager.getNames();

    int min = 0;
    int max = names.size() - 1;
    return names.get(random.nextInt(max - min + 1) + min);
  }

  public void dealCards() {
    this.game.dealCards();
  }

  private void requireAnte() {
    this.playerManager.getNames().forEach(name -> {
      try {
        Chip chip = this.playerManager.requestChip(name, DEFAULT_ANTE);
        chipManager.addToPot(name, chip);
      } catch (PlayerWithoutFoundsException e) {
        System.out.printf("Player %s without founds", name);
      }
    });
  }

  public void display() {
    game.show();
    System.out.printf("Pot: %d%n", this.chipManager.getPotTotal());
  }
}
