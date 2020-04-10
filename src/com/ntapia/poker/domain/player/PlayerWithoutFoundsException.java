package com.ntapia.poker.domain.player;

public class PlayerWithoutFoundsException extends RuntimeException {

  public PlayerWithoutFoundsException(String message) {
    super(message);
  }
}
