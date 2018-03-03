package io.trydent.tennis;

import java.util.function.Supplier;

public enum Score implements Supplier<Integer> {
  Love("0"), Fifteen("15"), Thirty("30"), Forty("40"), Advantage("A"), MoreAdvantage("Win");

  private final String display;

  Score(final String display) {
    this.display = display;
  }

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
    return display;
  }
}
