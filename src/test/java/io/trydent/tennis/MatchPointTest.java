package io.trydent.tennis;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static io.trydent.tennis.MatchPoint.IsMatchPoint;
import static io.trydent.tennis.Score.Advantage;
import static io.trydent.tennis.Score.Forty;
import static io.trydent.tennis.Score.Thirty;
import static io.trydent.tennis.Score.MoreAdvantage;

class MatchPointTest {
  @Test
  void shouldBeMatchPointWithAdvantageAndThirty() {
    assertThat(IsMatchPoint.test(Advantage, Thirty)).isTrue();
  }

  @Test
  void shouldBeMatchPointWithThirtyAndAdvantage() {
    assertThat(IsMatchPoint.test(Thirty, Advantage)).isTrue();
  }

  @Test
  void shouldBeAdvantageMatchPointWithMoreAdvantageAndForty() {
    assertThat(IsMatchPoint.test(MoreAdvantage, Forty)).isTrue();
  }

  @Test
  void shouldBeAdvantageMatchPointWithFortyAndMoreAdvantage() {
    assertThat(IsMatchPoint.test(Forty, MoreAdvantage)).isTrue();
  }
}