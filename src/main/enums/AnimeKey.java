package main.enums;

/**
 * AnimeKey
 * @author DPain
 *
 */
public enum AnimeKey {
  ON_AIR("a"),
  START_DATE("sd"),
  NAME("s"),
  TIME("t"),
  GENRE("g"),
  ID("i"),
  LINK("l"),
  END_DATE("ed");
  
  private final String value;

  AnimeKey(String value) {
      this.value = value;
  }

  public String toString() {
      return value;
  }
}
