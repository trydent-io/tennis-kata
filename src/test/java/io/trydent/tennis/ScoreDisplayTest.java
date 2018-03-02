package io.trydent.tennis;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class ScoreDisplayTest {
  @Test
  void serverShouldMakePoint() {
    final ScoreDisplay display = ScoreDisplay.with(
      new FakeScore(30, 40),
      new FakeScore(30, 30)
    );

    assertThat(
      display
        .serverPoint()
        .toString()
    ).isEqualTo("40:30");
  }

  @Test
  void serverShouldWin() {
    final ScoreDisplay display = ScoreDisplay.with(
      new FakeScore(40, 41),
      new FakeScore(30, 30)
    );

    assertThat(
      display
        .serverPoint()
        .toString()
    ).isEqualTo("Server wins!");
  }

  @Test
  void receiverShouldMakePoint() {
    final ScoreDisplay display = ScoreDisplay.with(
      new FakeScore(15, 15),
      new FakeScore(15, 30)
    );

    assertThat(
      display
        .receiverPoint()
        .toString()
    ).isEqualTo("15:30");
  }

  @Test
  void receiverShouldWinsAtAdvantages() {
    final ScoreDisplay display = ScoreDisplay.with(
      new FakeScore(40, 40),
      new FakeScore(46, 47)
    );

    assertThat(
      display
        .receiverPoint()
        .toString()
    ).isEqualTo("Receiver wins!");
  }

  @Test
  void finalScoreShouldBeFortyAndA() {
    final ScoreDisplay display = ScoreDisplay.with(
      new FakeScore(40, 40),
      new FakeScore(40, 46)
    );

    assertThat(
      display
        .receiverPoint()
        .toString()
    ).isEqualTo("40:A");
  }

  @Test
  void finalScoreShouldBeFortyAndForty() {
    final ScoreDisplay display = ScoreDisplay.with(
      new FakeScore(46, 40),
      new FakeScore(40, 40)
    );

    assertThat(
      display
        .receiverPoint()
        .toString()
    ).isEqualTo("40:40");
  }
}