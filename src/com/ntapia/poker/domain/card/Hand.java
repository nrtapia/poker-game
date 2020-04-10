package com.ntapia.poker.domain.card;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Hand {

  private static final int MAX_CARDS = 5;

  private ArrayList<Card> cards;

  public Hand() {
    this.cards = new ArrayList<>();
  }

  public void addCard(Card card) {
    if (cards.size() <= MAX_CARDS) {
      cards.add(card);
      return;
    }
    throw new IllegalArgumentException("The hand only must have max 5 cards");
  }

  @Override
  public String toString() {
    return cards.stream().map(Card::toString)
        .collect(Collectors.joining(", "));
  }
}
