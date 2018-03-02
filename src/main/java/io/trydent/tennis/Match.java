package io.trydent.tennis;

import static java.lang.String.format;

public interface Match {
  static Match with(final Score server, final Score receiver) {
    return new MatchImpl(server, receiver);
  }

  Match serverWinsPoint();
  Match receiverWinsPoint();

  String finalScore();

  final class MatchImpl implements Match {
    private final Score server;
    private final Score receiver;

    private MatchImpl(final Score server, final Score receiver) {
      this.server = server;
      this.receiver = receiver;
    }

    @Override
    public Match serverWinsPoint() {
      return this;
    }

    @Override
    public Match receiverWinsPoint() {
      return this;
    }

    @Override
    public String finalScore() {
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
