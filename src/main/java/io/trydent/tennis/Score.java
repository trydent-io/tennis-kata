package io.trydent.tennis;

import java.util.function.Supplier;

public enum Score implements Supplier<Integer> {
  Love(0), Fifteen(1), Thirty(2), Forty(3), Advantage(4), MoreAdvantage(5);

  private final int scoring;

  Score(final int scoring) {
    this.scoring = scoring;
  }

  public int value() {
    return scoring;
  }

  @Override
  public Integer get() {
    return value();
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
      default: return "Win";
    }
  }
}
