package com.ntapia.poker.application;

import com.ntapia.poker.domain.card.Card;
import com.ntapia.poker.domain.card.Suit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CardManager {

  private static final String JACK = "J";
  private static final String QUEEN = "Q";
  private static final String KING = "K";
  private static final String ACE = "A";

  private ArrayList<Card> cards;
  private int index;

  public CardManager() {
    create();
  }

  private void create() {
    this.cards = new ArrayList<>();

    IntStream.rangeClosed(2, 10).forEach(value -> {
      for (Suit suit : Suit.values()) {
        this.cards.add(new Card(value, suit));
      }
    });

    for (Suit suit : Suit.values()) {
      this.cards.add(new Card(JACK, 11, suit));
      this.cards.add(new Card(QUEEN, 12, suit));
      this.cards.add(new Card(KING, 13, suit));
      this.cards.add(new Card(ACE, 1, 14, suit));
    }

    index = 0;
  }

  public void shuffle() {
    Collections.shuffle(this.cards);
    index = 0;
  }

  public Card getCard() {
    if (index < cards.size()) {
      final Card card = cards.get(index);
      index++;
      return card;
    }

    throw new IllegalStateException("Card pack is empty!");
  }

  @Override
  public String toString() {
    return this.cards.stream().map(Card::toString)
        .collect(Collectors.joining(", "));
  }
}
