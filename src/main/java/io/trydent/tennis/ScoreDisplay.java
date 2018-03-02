package io.trydent.tennis;

import static java.lang.String.format;

public interface ScoreDisplay {
  static ScoreDisplay with(final Score server, final Score receiver) {
    return new ScoreDisplayImpl(server, receiver);
  }

  ScoreDisplay serverPoint();
  ScoreDisplay receiverPoint();

  final class ScoreDisplayImpl implements ScoreDisplay {
    private final Score server;
    private final Score receiver;

    private ScoreDisplayImpl(final Score server, final Score receiver) {
      this.server = server;
      this.receiver = receiver;
    }

    @Override
    public ScoreDisplay serverPoint() {
      server.inc();
      return this;
    }

    @Override
    public ScoreDisplay receiverPoint() {
      receiver.inc();
      return this;
    }

    @Override
    public String toString() {
      return server.value() == 41 && receiver.value() == 30
        ? "Server wins!"
        : server.value() == 40 && receiver.value() == 46
        ? format("%s:A", server)
        : server.value() == 40 && receiver.value() == 47
        ? "Receiver wins!"
        : format("%s:%s", server, receiver);
    }
  }
}
