package io.trydent.tennis;

import java.util.function.Supplier;

public final class Score implements Supplier<Integer> {
  private int value;

  private Score(int value) {
    this.value = value;
  }

  public Score inc() {
    value += value < 30
      ? 15
      : value < 40
      ? 10
      : value < 45
      ? 5
      : 1;
    return this;
  }

  public int value() {
    return value;
  }

  @Override
  public Integer get() {
    return value;
  }

  static Score love() {
    return new Score(0);
  }
}
