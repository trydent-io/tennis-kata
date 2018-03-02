package io.trydent.tennis;

import static io.trydent.tennis.Score.Advantage;
import static io.trydent.tennis.Score.Forty;
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
      return point(true);
    }

    @Override
    public ScoreDisplay receiverPoint() {
      return point(false);
    }

    private ScoreDisplay point(final boolean forServer) {
      final Score s = forServer ? server.inc() : server;
      final Score r = !forServer ? receiver.inc() : receiver;
      return s == r && s == Advantage
        ? ScoreDisplay.with(Forty, Forty)
        : ScoreDisplay.with(s, r);
    }

    @Override
    public String toString() {
      return server.ordinal() - receiver.ordinal() >= 2
        ? "Server wins!"
        : receiver.ordinal() - server.ordinal() >= 2
        ? "Receiver wins!"
        : format("%s:%s", server, receiver);
    }
  }
}
