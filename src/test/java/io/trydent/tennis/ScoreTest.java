package io.trydent.tennis;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class ScoreTest {
  private Score score;

  @BeforeEach
  void beforeEach() {
    score = Score.love();
  }

  @Test
  void shouldBeZero() {
    assertThat(score.value()).isEqualTo(0);
  }

  @Test
  void shouldIncreaseToFifteen() {
    assertThat(score.inc().value()).isEqualTo(15);
  }

  @Test
  void shouldIncreseTwiceThenThirty() {
    assertThat(score.inc().inc().value()).isEqualTo(30);
  }

  @Test
  void shouldIncreaseTriceThenForty() {
    assertThat(score.inc().inc().inc().value()).isEqualTo(40);
  }

  @Test
  void shouldIncreaseFourTimesThenFortyFive() {
    assertThat(score.inc().inc().inc().inc().value()).isEqualTo(45);
  }

  @Test
  void shouldIncreaseMoreThanFourTimesThenFortySeven() {
    assertThat(
      score
        .inc()
        .inc()
        .inc()
        .inc()
        .inc()
        .inc()
        .value()
    ).isEqualTo(47);
  }
}
