package com.ntapia.poker.application;

import com.ntapia.poker.domain.chip.Chip;
import java.util.List;

public interface PlayerManager {

  void register(String name, List<Chip> chips);

  Chip requestChip(String playerName, int value);

  void addChips(String playerName, List<Chip> chips);

  List<String> getPlayersNames();

}
