package io.trydent.tennis;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static io.trydent.tennis.MatchPoint.MatchPointImpl;
import static io.trydent.tennis.Score.Advantage;
import static io.trydent.tennis.Score.Thirty;

class MatchPointTest {
  @Test
  void shouldBeMatchPointWithAdvantageAndThirty() {
    final MatchPoint matchPoint = new MatchPointImpl(Advantage, Thirty);

    assertThat(matchPoint.test()).isTrue();
  }

  @Test
  void shouldBeMatchPointWithThirtyAndAdvantage() {
    final MatchPoint matchPoint = new MatchPointImpl(Thirty, Advantage);

    assertThat(matchPoint.test()).isTrue();
  }
}