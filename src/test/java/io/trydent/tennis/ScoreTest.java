package io.trydent.tennis;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class ScoreTest {
  private Score score;

  @BeforeEach
  void beforeEach() {
    score = Score.Love;
  }

  @Test
  void shouldBeZero() {
    assertThat(score.toString()).isEqualTo("0");
  }

  @Test
  void shouldIncreaseToFifteen() {
    assertThat(score.inc().toString()).isEqualTo("15");
  }

  @Test
  void shouldIncreseTwiceThenThirty() {
    assertThat(score.inc().inc().toString()).isEqualTo("30");
  }

  @Test
  void shouldIncreaseTriceThenForty() {
    assertThat(score.inc().inc().inc().toString()).isEqualTo("40");
  }

  @Test
  void shouldIncreaseFourTimesThenAdvantage() {
    assertThat(score.inc().inc().inc().inc().toString()).isEqualTo("A");
  }

  @Test
  void shouldDecreaseToForty() {
    assertThat(
      score
        .inc()
        .inc()
        .inc()
        .inc()
        .inc()
        .inc()
        .inc()
        .toString()
    ).isEqualTo("40");
  }
}
