package main.enums;

/**
 * SubtitleKey
 * @author DPain
 *
 */
public enum SubtitleKey {
  EPISODE("s"),
  DATETIME("d"),
  LINK("a"),
  NAME("n");
  
  private final String value;

  SubtitleKey(String value) {
      this.value = value;
  }

  @Override
  public String toString() {
      return value;
  }
}
