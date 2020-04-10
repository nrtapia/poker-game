package com.ntapia.poker.application;

import com.ntapia.poker.domain.score.Score;

public interface GameManager {

  void start();

  void shuffleCards();

  Score evaluateWinner();

  void initialDeal();

  void dealCards();

  void display();

}
