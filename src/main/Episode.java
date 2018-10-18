package main;

import java.util.Optional;

enum Type {
  BD, EX, PIC, OVA, OAD;
}


public class Episode {
  public int num;
  public int subNum;
  public Optional<Type> type;

  public Episode() {
    num = 0;
    subNum = 0;
    type = Optional.empty();
  }

  @Override
  public String toString() {
    return String.format("Episode [num=%s, subNum=%s, type=%s]", num, subNum, type.toString());
  }
}
