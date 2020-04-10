package com.ntapia.poker.domain.card;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Hand {

  private ArrayList<Card> cards;

  public Hand() {
    this.cards = new ArrayList<>();
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  @Override
  public String toString() {
    return cards.stream().map(Card::toString)
        .collect(Collectors.joining(", "));
  }
}
