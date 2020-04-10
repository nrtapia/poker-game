package com.ntapia.poker.domain.chip;

public class ChipTransaction {

  public enum Type {
    DEBIT,
    CREDIT
  }

  private String playerName;
  private Chip chip;
  private Type type;

  public ChipTransaction() {
  }

  public ChipTransaction(String playerName, Chip chip, Type type) {
    this.playerName = playerName;
    this.chip = chip;
    this.type = type;
  }

  public static ChipTransaction createDebit(String playerName, Chip chip) {
    return new ChipTransaction(playerName, chip, Type.DEBIT);
  }

  public static ChipTransaction createCredit(String playerName, Chip chip) {
    return new ChipTransaction(playerName, chip, Type.CREDIT);
  }
}
