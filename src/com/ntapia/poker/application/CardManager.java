package com.ntapia.poker.application;

import com.ntapia.poker.domain.card.Card;

public interface CardManager {

  void shuffle();

  Card getCard();

  String toString();
}
