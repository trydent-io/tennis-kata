package io.trydent.tennis;

import java.util.function.Supplier;

public interface Score extends Supplier<Integer> {
  static Score love() {
    return new ScoreImpl(0);
  }

  Score inc();
  int value();
  default Integer get() { return value(); }

  final class ScoreImpl implements Score {
    private int value;

    ScoreImpl(int value) {
      this.value = value;
    }

    @Override
    public int value() {
      return value;
    }

    @Override
    public Score inc() {
      value += value < 30
        ? 15
        : value < 40
        ? 10
        : value < 42
        ? 1
        : 0;
      return this;
    }

    @Override
    public String toString() {
      return Integer.toString(value);
    }
  }
}
