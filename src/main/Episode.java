package main;

import java.util.Optional;

enum Type {
  BD, EX, PIC, OVA, OAD;
}


/**
 * Episode
 * 
 * @author DPain
 *
 */
public class Episode {
  public Optional<Integer> num;
  public Optional<Integer> subNum;
  public Optional<Type> type;

  public Episode() {
    num = Optional.empty();
    subNum = Optional.empty();
    type = Optional.empty();
  }

  @Override
  public String toString() {
    return String.format("Episode [num=%s, subNum=%s, type=%s]", num, subNum, type.toString());
  }
}
