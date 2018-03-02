package io.trydent.tennis;

import java.util.function.Supplier;

public enum Score implements Supplier<Integer> {
  Love, Fifteen, Thirty, Forty, Advantage, MoreAdvantage;

  @Override
  public Integer get() {
    return ordinal();
  }

  public Score inc() {
    switch (this) {
      case Love: return Fifteen;
      case Fifteen: return Thirty;
      case Thirty: return Forty;
      case Forty: return Advantage;
      case Advantage: return MoreAdvantage;
      default: return MoreAdvantage;
    }
  }

  @Override
  public String toString() {
    switch (this) {
      case Love: return 0 + "";
      case Fifteen: return 15 + "";
      case Thirty: return 30 + "";
      case Forty: return 40 + "";
      case Advantage: return "A";
      default: return "A+";
    }
  }
}
