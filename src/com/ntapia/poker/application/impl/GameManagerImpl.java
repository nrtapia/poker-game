package com.ntapia.poker.application.impl;

import com.ntapia.poker.application.ChipManager;
import com.ntapia.poker.application.GameManager;
import com.ntapia.poker.application.PlayerManager;
import com.ntapia.poker.application.ScoreManager;
import com.ntapia.poker.domain.chip.Chip;
import com.ntapia.poker.domain.game.Game;
import com.ntapia.poker.domain.game.GameCommand;
import com.ntapia.poker.domain.player.Player;
import com.ntapia.poker.domain.player.PlayerWithoutFoundsException;
import com.ntapia.poker.domain.score.Score;
import java.util.List;
import java.util.Random;

public class GameManagerImpl implements GameManager {

  private static final int DEFAULT_ANTE = 1;

  private final Game game;
  private final PlayerManager playerManager;
  private final ScoreManager scoreManager;
  private final ChipManager chipManager;
  private Random random = new Random();

  public GameManagerImpl(PlayerManager playerManager,
      ScoreManager scoreManager) {
    this.playerManager = playerManager;
    this.scoreManager = scoreManager;
    this.chipManager = new ChipManagerImpl();
    this.game = new Game(playerManager.getPlayersNames());
  }

  @Override
  public void start() {
    System.out.printf("%nStarting the game...%n");
    shuffleCards();
    initialDeal();
    requireAnte();
  }

  @Override
  public void initialDeal() {
    game.initialDeal();
  }

  @Override
  public void shuffleCards() {
    game.shuffleCards();
  }

  @Override
  public Score evaluateWinner() {
    final String playerName = getRandomPlayerName();

    final List<Chip> chips = chipManager.claimPot(playerName);
    this.playerManager.addChips(playerName, chips);
    final Score score = new Score(playerName, game.getPlayerHand(playerName), chips);
    scoreManager.addScore(score);

    return score;
  }

  private String getRandomPlayerName() {
    List<String> names = this.playerManager.getPlayersNames();

    int min = 0;
    int max = names.size() - 1;
    return names.get(random.nextInt(max - min + 1) + min);
  }

  @Override
  public void dealCards() {
    this.game.dealCards();
  }

  private void requireAnte() {
    this.playerManager.getPlayersNames().forEach(name -> {
      try {
        Chip chip = this.playerManager.requestChip(name, DEFAULT_ANTE);
        chipManager.addToPot(name, chip);
      } catch (PlayerWithoutFoundsException e) {
        System.out.printf("Player %s without founds", name);
      }
    });
  }

  @Override
  public void display() {
    game.show();
    System.out.printf("Pot: %d%n", this.chipManager.getPotTotal());
  }

  @Override
  public void nextPlay() {
    Player player = this.playerManager.getPlayer(getRandomPlayerName());
    GameCommand command = player.play();
  }
}
