package io.trydent.tennis;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class ScoreDisplayIT {
  @Test
  void whenServerTakesPointThenScores() {
    final ScoreDisplay display = ScoreDisplay.with(
      Score.love(),
      Score.love()
    );

    assertThat(display.serverPoint() + "").isEqualTo("15:0");
  }

  @Test
  void whenReceiverTakesPointThenScores() {
    final ScoreDisplay display = ScoreDisplay.with(
      Score.fifteen(),
      Score.fifteen()
    );

    assertThat(display.receiverPoint() + "").isEqualTo("15:30");
  }

  @Test
  void whenServerTakesPointThenScoresAgain() {
    final ScoreDisplay display = ScoreDisplay.with(
      Score.thirty(),
      Score.thirty()
    );

    assertThat(display.serverPoint() + "").isEqualTo("40:30");
  }

  @Test
  void whenServerTakesPointThenWins() {
    final ScoreDisplay display = ScoreDisplay.with(
      Score.forty(),
      Score.thirty()
    );

    assertThat(display.serverPoint() + "").isEqualTo("Server wins!");
  }
}