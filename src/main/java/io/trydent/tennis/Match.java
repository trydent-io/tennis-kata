package io.trydent.tennis;

public interface Match {
  static Match of(String server, Score serverScore, String receiver, Score receiverScore) {
    return new MatchImpl(server, receiver, serverScore, receiverScore);
  }

  void serverPoints();

  String score();

  final class MatchImpl implements Match {
    private final String server;
    private final String receiver;
    private final Score serverScore;
    private final Score receiverScore;

    MatchImpl(String server, String receiver, Score serverScore, Score receiverScore) {
      this.server = server;
      this.receiver = receiver;
      this.serverScore = serverScore;
      this.receiverScore = receiverScore;
    }

    @Override
    public void serverPoints() {
      serverScore.inc();
    }

    @Override
    public String score() {
      return serverScore.value() + ":" + receiverScore.value();
    }
  }
}
