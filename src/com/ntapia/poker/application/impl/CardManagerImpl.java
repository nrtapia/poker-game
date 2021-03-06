package com.ntapia.poker.application.impl;

import com.ntapia.poker.application.CardManager;
import com.ntapia.poker.domain.card.Card;
import com.ntapia.poker.domain.card.Suit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CardManagerImpl implements CardManager {

  private static final String JACK = "J";
  private static final String QUEEN = "Q";
  private static final String KING = "K";
  private static final String ACE = "A";

  private static final List<Card> DEFAULT_DECK;

  static {
    DEFAULT_DECK = new ArrayList<>();

    IntStream.rangeClosed(2, 10).forEach(value -> {
      for (Suit suit : Suit.values()) {
        DEFAULT_DECK.add(new Card(value, suit));
      }
    });

    for (Suit suit : Suit.values()) {
      DEFAULT_DECK.add(new Card(JACK, 11, suit));
      DEFAULT_DECK.add(new Card(QUEEN, 12, suit));
      DEFAULT_DECK.add(new Card(KING, 13, suit));
      DEFAULT_DECK.add(new Card(ACE, 1, 14, suit));
    }
  }

  private ArrayList<Card> cards;
  private int index;

  public CardManagerImpl() {
    create();
  }

  private void create() {
    this.cards = new ArrayList<>(DEFAULT_DECK);
    index = 0;
  }

  @Override
  public void shuffle() {
    Collections.shuffle(this.cards);
    index = 0;
  }

  @Override
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
