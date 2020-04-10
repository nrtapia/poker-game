package com.ntapia.poker.application;

import com.ntapia.poker.domain.chip.Chip;
import java.util.List;

public interface ChipManager {

  void addToPot(String playerName, Chip chip);

  List<Chip> claimPot(String playerName);

  int getPotTotal();

  List<Chip> buildBaseChipsForPlayer();

}
