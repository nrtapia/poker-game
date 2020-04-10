package com.ntapia.poker.application;

import com.ntapia.poker.domain.chip.Chip;
import com.ntapia.poker.domain.chip.ChipTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChipManager {

  private List<Chip> pot;
  private List<ChipTransaction> chipTransactions;

  public ChipManager() {
    this.pot = new ArrayList<>();
    this.chipTransactions = new ArrayList<>();
  }

  public void addToPot(String playerName, Chip chip) {
    pot.add(chip);
    registerDebit(playerName, chip);
  }

  public List<Chip> claimPot(String playerName) {
    this.pot.forEach(chip -> this.registerCredit(playerName, chip));

    final List<Chip> potValues = new ArrayList<>(this.pot);
    this.pot = new ArrayList<>();

    return potValues;
  }

  private void registerDebit(String playerName, Chip chip) {
    this.chipTransactions.add(ChipTransaction.createCredit(playerName, chip));
  }

  private void registerCredit(String playerName, Chip chip) {
    this.chipTransactions.add(ChipTransaction.createCredit(playerName, chip));
  }

  public int getPotTotal() {
    return this.pot.stream().map(Chip::getValue).reduce(0, Integer::sum);
  }

  public List<Chip> buildBaseChipsForPlayer() {
    return IntStream.rangeClosed(1, 5)
        .mapToObj(value -> new Chip(String.valueOf(value), value))
        .collect(Collectors.toList());
  }
}
