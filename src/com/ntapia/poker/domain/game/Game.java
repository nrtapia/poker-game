package com.ntapia.poker.domain.game;

import com.ntapia.poker.application.impl.CardManagerImpl;
import com.ntapia.poker.domain.card.Hand;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.IntStream;

public class Game {

  private final LinkedHashMap<String, Hand> playersHands;
  private final CardManagerImpl cardsPack;
  private final Hand boardCards;

  public Game(List<String> playersNames) {
    this.cardsPack = new CardManagerImpl();
    this.playersHands = new LinkedHashMap<>();
    this.boardCards = new Hand();
    playersNames.forEach(name -> this.playersHands.put(name, new Hand()));
  }

  public void show() {
    System.out.printf("%n-- Game Status --%n");
    System.out.printf("Board hand: %s%n", this.boardCards.toString());
    System.out.println("- Players -");
    this.playersHands.forEach(
        (player, hand) -> System.out.printf("Player: %s Hand: %s%n", player, hand.toString()));
  }

  public void shuffleCards() {
    System.out.println("Scuffling cards...");
    this.cardsPack.shuffle();
  }

  public void dealCards() {
    playersHands.forEach((player, hand) -> {
      System.out.printf("Deal card to player: %s%n", player);
      hand.addCard(cardsPack.getCard());
    });
  }

  public void initialDeal() {
    System.out.println("Initial deal...");

    dealCards();
    dealCards();

    IntStream.rangeClosed(1, 5).forEach(value -> this.boardCards.addCard(cardsPack.getCard()));
  }

  public Hand getPlayerHand(String playerName) {
    return this.playersHands.get(playerName);
  }
}
