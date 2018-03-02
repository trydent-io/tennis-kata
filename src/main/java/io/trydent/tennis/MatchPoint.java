package io.trydent.tennis;

import static io.trydent.tennis.Score.Advantage;
import static io.trydent.tennis.Score.Thirty;

public interface MatchPoint {
  boolean test();

  final class MatchPointImpl implements MatchPoint {
    private final Score server;
    private final Score receiver;

    MatchPointImpl(Score server, Score receiver) {
      this.server = server;
      this.receiver = receiver;
    }

    @Override
    public boolean test() {
      return (server == Advantage && receiver == Thirty) || (server == Thirty && receiver == Advantage);
    }
  }
}
