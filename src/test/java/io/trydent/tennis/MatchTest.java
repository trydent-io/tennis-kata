package io.trydent.tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class MatchTest {
  private Match match;

  @BeforeEach
  void beforeEach() {
    this.match = Match.of(
      "Player One", Score.love(),
      "Player Two", Score.love()
    );
  }

  @Test
  void shouldServerPointThen15_0() {
    match.serverPoints();

    assertThat(match.score()).isEqualTo("15:0");
  }
}