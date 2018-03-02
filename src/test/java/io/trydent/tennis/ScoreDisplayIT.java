package io.trydent.tennis;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static io.trydent.tennis.Score.Fifteen;
import static io.trydent.tennis.Score.Forty;
import static io.trydent.tennis.Score.Love;
import static io.trydent.tennis.Score.Thirty;

class ScoreDisplayIT {
  @Test
  void whenServerTakesPointThenScores() {
    final ScoreDisplay display = ScoreDisplay.with(Love, Love);

    assertThat(display.serverPoint() + "").isEqualTo("15:0");
  }

  @Test
  void whenReceiverTakesPointThenScores() {
    final ScoreDisplay display = ScoreDisplay.with(Fifteen, Fifteen);

    assertThat(display.receiverPoint() + "").isEqualTo("15:30");
  }

  @Test
  void whenServerTakesPointThenScoresAgain() {
    final ScoreDisplay display = ScoreDisplay.with(Thirty, Thirty);

    assertThat(display.serverPoint() + "").isEqualTo("40:30");
  }

  @Test
  void whenServerTakesPointThenWins() {
    final ScoreDisplay display = ScoreDisplay.with(Forty, Thirty);

    assertThat(display.serverPoint() + "").isEqualTo("Server wins!");
  }
}