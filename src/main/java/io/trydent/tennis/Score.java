package io.trydent.tennis;

import java.util.function.IntSupplier;

public interface Score extends IntSupplier {
  static Score love() {
    return new ScoreImpl(0);
  }

  Score inc();
  default int value() { return getAsInt(); }

  final class ScoreImpl implements Score {
    private int value;

    ScoreImpl(int value) {
      this.value = value;
    }

    @Override
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

    @Override
    public int getAsInt() {
      return value;
    }
  }
}
