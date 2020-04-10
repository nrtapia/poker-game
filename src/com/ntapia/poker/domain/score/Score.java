package com.ntapia.poker.domain.score;

import com.ntapia.poker.domain.card.Hand;
import com.ntapia.poker.domain.chip.Chip;
import java.util.List;

public class Score {

  private String playerName;
  private Hand winnerHand;
  private List<Chip> earnedPot;

  public Score(String playerName, Hand winnerHand,
      List<Chip> earnedPot) {
    this.playerName = playerName;
    this.winnerHand = winnerHand;
    this.earnedPot = earnedPot;
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public Hand getWinnerHand() {
    return winnerHand;
  }

  public void setWinnerHand(Hand winnerHand) {
    this.winnerHand = winnerHand;
  }

  public List<Chip> getEarnedPot() {
    return earnedPot;
  }

  public void setEarnedPot(List<Chip> earnedPot) {
    this.earnedPot = earnedPot;
  }
}
