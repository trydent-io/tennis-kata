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
      return point(true);
    }

    @Override
    public ScoreDisplay receiverPoint() {
      return point(false);
    }

    private ScoreDisplay point(final boolean forServer) {
      final ScoreDisplayImpl d = new ScoreDisplayImpl(
        // check server
        forServer ? (
          server == Advantage && server != receiver
            ? Win
            : server.inc()
        ) : server,

        // check receiver
        !forServer ? (
          receiver == Advantage && receiver != server
            ? Win
            : receiver.inc()
        ) : receiver
      );
      return d.server == d.receiver && d.server == Advantage
        ? new ScoreDisplayImpl(Forty, Forty)
        : d;
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
