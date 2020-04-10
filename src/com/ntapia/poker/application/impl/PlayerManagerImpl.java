package com.ntapia.poker.application.impl;

import com.ntapia.poker.application.PlayerManager;
import com.ntapia.poker.domain.chip.Chip;
import com.ntapia.poker.domain.player.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerManagerImpl implements PlayerManager {

  private Map<String, Player> players;

  public PlayerManagerImpl() {
    this.players = new HashMap<>();
  }

  @Override
  public void register(String name, List<Chip> chips) {
    System.out.printf("Register Player: %s%n", name);
    players.put(name, new Player(name, chips));
  }

  @Override
  public Chip requestChip(String playerName, int value) {
    if (players.containsKey(playerName)) {
      return players.get(playerName).requestChip(value);
    }
    throw new IllegalArgumentException(String.format("Player %s not found", playerName));
  }

  @Override
  public void addChips(String playerName, List<Chip> chips) {
    if (players.containsKey(playerName)) {
      players.get(playerName).addChips(chips);
      return;
    }
    throw new IllegalArgumentException(String.format("Player %s not found", playerName));
  }

  @Override
  public List<String> getPlayersNames() {
    return new ArrayList<>(players.keySet());
  }
}
