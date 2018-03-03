package io.trydent.tennis;

import java.util.function.Supplier;

public enum Score implements Supplier<Integer> {
  Love, Fifteen, Thirty, Forty, Advantage, MoreAdvantage;

  @Override
  public Integer get() {
    return ordinal();
  }

  public Score inc() {
    return Score.values()[
      this.ordinal() < values().length - 1
        ? this.ordinal() + 1
        : this.ordinal()
      ];
  }

  @Override
  public String toString() {
    switch (this) {
      case Love:
        return 0 + "";
      case Fifteen:
        return 15 + "";
      case Thirty:
        return 30 + "";
      case Forty:
        return 40 + "";
      case Advantage:
        return "A";
      default:
        return "A+";
    }
  }
}
