package com.ntapia.poker.application;

import com.ntapia.poker.domain.score.Score;
import java.util.List;

public interface ScoreManager {

  void addScore(Score score);

  List<Score> getScores();
}
