package io.trydent.tennis;

import java.util.function.Supplier;

public enum Score implements Supplier<Integer> {
  Love(0), Fifteen(15), Thirty(30), Forty(40), Advantage(41);


  private final int value;

  Score(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }

  @Override
  public Integer get() {
    return value();
  }

  public Score inc() {
    switch (value) {
      case 0: return Fifteen;
      case 15: return Thirty;
      case 30: return Forty;
      case 40: return Advantage;
      default: return Forty;
    }
  }

  @Override
  public String toString() {
    return Integer.toString(value);
  }
}
