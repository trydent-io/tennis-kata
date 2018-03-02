package io.trydent.tennis;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static io.trydent.tennis.Deuce.IsDeuce;
import static io.trydent.tennis.Score.Forty;

class DeuceTest {
  @Test
  void shouldBeDeuceWhenFortyAndForty() {
    assertThat(IsDeuce.test(Forty, Forty)).isTrue();
  }
}