package io.trydent.tennis;

import java.util.function.BiPredicate;

import static io.trydent.tennis.Score.Forty;

public enum Deuce implements BiPredicate<Score, Score> {
  IsDeuce;

  @Override
  public boolean test(Score server, Score receiver) {
    return server == Forty && receiver == Forty;
  }
}
