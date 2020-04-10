package com.ntapia.poker.domain.card;

import java.util.Objects;

public class Card {

  private String label;
  private int value1;
  private int value2;
  private Suit suit;

  public Card(int value, Suit suit) {
    this.label = String.valueOf(value);
    this.value1 = value;
    this.value2 = value;
    this.suit = suit;
  }

  public Card(String label, int value1, int value2, Suit suit) {
    this.label = label;
    this.value1 = value1;
    this.value2 = value2;
    this.suit = suit;
  }

  public Card(String label, int value, Suit suit) {
    this.label = label;
    this.value1 = value;
    this.value2 = value;
    this.suit = suit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return value1 == card.value1 &&
        label.equals(card.label) &&
        suit == card.suit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, value1, suit);
  }

  @Override
  public String toString() {
    return String.format("%s %s", label, suit.toString());
  }
}
