package com.ntapia.poker.application.impl;

import com.ntapia.poker.application.ScoreManager;
import com.ntapia.poker.domain.score.Score;
import java.util.ArrayList;
import java.util.List;

public class ScoreManagerImpl implements ScoreManager {

  private List<Score> scores;

  public ScoreManagerImpl() {
    scores = new ArrayList<>();
  }

  public void addScore(Score score) {
    this.scores.add(score);
  }

  public List<Score> getScores() {
    return scores;
  }
}
