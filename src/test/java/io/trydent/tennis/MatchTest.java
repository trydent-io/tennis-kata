package io.trydent.tennis;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class MatchTest {
  @Test
  void serverShouldMakePoint() {
    final Match match = Match.with(
      new FakeScore(30, 40),
      new FakeScore(30, 30)
    );

    assertThat(
      match
        .serverWinsPoint()
        .finalScore()
    ).isEqualTo("40:30");
  }

  @Test
  void serverShouldWin() {
    final Match match = Match.with(
      new FakeScore(40, 41),
      new FakeScore(30, 30)
    );

    assertThat(
      match
        .serverWinsPoint()
        .finalScore()
    ).isEqualTo("Server wins!");
  }

  @Test
  void receiverShouldMakePoint() {
    final Match match = Match.with(
      new FakeScore(15, 15),
      new FakeScore(15, 30)
    );

    assertThat(
      match
        .receiverWinsPoint()
        .finalScore()
    ).isEqualTo("15:30");
  }

  @Test
  void receiverShouldWinsAtAdvantages() {
    final Match match = Match.with(
      new FakeScore(40, 40),
      new FakeScore(46, 47)
    );

    assertThat(
      match
        .receiverWinsPoint()
        .finalScore()
    ).isEqualTo("Receiver wins!");
  }

  @Test
  void finalScoreShouldBeFortyAndA() {
    final Match match = Match.with(
      new FakeScore(40, 40),
      new FakeScore(40, 46)
    );

    assertThat(
      match
        .receiverWinsPoint()
        .finalScore()
    ).isEqualTo("40:A");
  }

  @Test
  void finalScoreShouldBeFortyAndForty() {
    final Match match = Match.with(
      new FakeScore(46, 40),
      new FakeScore(40, 40)
    );

    assertThat(
      match
        .receiverWinsPoint()
        .finalScore()
    ).isEqualTo("40:40");
  }
}