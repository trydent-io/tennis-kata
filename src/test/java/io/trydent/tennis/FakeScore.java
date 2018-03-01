package io.trydent.tennis;

final class FakeScore implements Score {
  private final int value;
  private final int inc;

  FakeScore(int value, int inc) {
    this.value = value;
    this.inc = inc;
  }

  @Override
  public Score inc() {
    return this;
  }

  @Override
  public int value() {
    return inc;
  }

  @Override
  public String toString() {
    return inc + "";
  }
}
