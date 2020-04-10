package com.ntapia.poker.application;

import com.ntapia.poker.domain.chip.Chip;
import com.ntapia.poker.domain.player.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerManager {

  private Map<String, Player> players;

  public PlayerManager() {
    this.players = new HashMap<>();
  }

  public void register(String name, List<Chip> chips) {
    players.put(name, new Player(name, chips));
  }

  public Chip requestChip(String playerName, int value) {
    if (players.containsKey(playerName)) {
      return players.get(playerName).requestChip(value);
    }
    throw new IllegalArgumentException("Player not found");
  }

  public List<String> getNames() {
    return new ArrayList<>(players.keySet());
  }
}
