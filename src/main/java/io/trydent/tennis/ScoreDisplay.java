package io.trydent.tennis;

import static io.trydent.tennis.Score.Advantage;
import static io.trydent.tennis.Score.Forty;
import static io.trydent.tennis.Score.Win;
import static java.lang.String.format;

public interface ScoreDisplay {
  static ScoreDisplay with(final Score server, final Score receiver) {
    return new ScoreDisplayImpl(server, receiver);
  }

  ScoreDisplay serverPoint();
  ScoreDisplay receiverPoint();

  final class ScoreDisplayImpl implements ScoreDisplay {
    private Score server;
    private Score receiver;

    private ScoreDisplayImpl(final Score server, final Score receiver) {
      this.server = server;
      this.receiver = receiver;
    }

    @Override
    public ScoreDisplay serverPoint() {
      server = server == Advantage
        ? Win
        : server.inc();
      if (server == receiver && server == Advantage) {
        server = Forty;
        receiver = Forty;
      }
      return this;
    }

    @Override
    public ScoreDisplay receiverPoint() {
      receiver = receiver == Advantage
        ? Win
        : receiver.inc();
      if (server == receiver && receiver == Advantage) {
        server = Forty;
        receiver = Forty;
      }
      return this;
    }

    @Override
    public String toString() {
      return server.value() - receiver.value() >= 2
        ? "Server wins!"
        : receiver.value() - server.value() >= 2
        ? "Receiver wins!"
        : format("%s:%s", server, receiver);
    }
  }
}
