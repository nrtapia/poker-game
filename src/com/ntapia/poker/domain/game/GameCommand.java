package com.ntapia.poker.domain.game;

import com.ntapia.poker.domain.chip.Chip;

public class GameCommand {

  public enum Action {
    FOLD,
    BET,
    CALL
  }

  private Action action;
  private Chip chip;

  public GameCommand(Action action) {
    this.action = action;
    this.chip = null;
  }

  public GameCommand(Action action, Chip chip) {
    this.action = action;
    this.chip = chip;
  }

  public Action getAction() {
    return action;
  }

  public Chip getChip() {
    return chip;
  }

  @Override
  public String toString() {
    return "GameCommand{" +
        "action=" + action +
        ", chip=" + chip +
        '}';
  }
}
