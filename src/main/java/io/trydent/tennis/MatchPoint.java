package io.trydent.tennis;

import java.util.function.BiPredicate;

import static io.trydent.tennis.Score.Advantage;
import static io.trydent.tennis.Score.Forty;
import static io.trydent.tennis.Score.MoreAdvantage;
import static io.trydent.tennis.Score.Thirty;

public enum MatchPoint implements BiPredicate<Score, Score> {
  IsMatchPoint;

  @Override
  public boolean test(Score server, Score receiver) {
    return
      (server == Advantage && receiver == Thirty)
        || (server == Thirty && receiver == Advantage)
        || (server == MoreAdvantage && receiver == Forty)
        || (server == Forty && receiver == MoreAdvantage);
  }
}
