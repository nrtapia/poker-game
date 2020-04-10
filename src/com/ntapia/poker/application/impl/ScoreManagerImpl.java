package com.ntapia.poker.application;

import com.ntapia.poker.domain.score.Score;
import java.util.ArrayList;
import java.util.List;

public class ScoreManager {

  private List<Score> scores;

  public ScoreManager() {
    scores = new ArrayList<>();
  }

  public void addScore(Score score) {
    this.scores.add(score);
  }

  public List<Score> getScores() {
    return scores;
  }

  public void setScores(List<Score> scores) {
    this.scores = scores;
  }
}
