package main.enums;

/**
 * SubtitleKey
 * @author DPain
 *
 */
public enum SubtitleKey {
  EPISODE("s"),
  DATE("d"),
  LINK("a"),
  NAME("n");
  
  private final String value;

  SubtitleKey(String value) {
      this.value = value;
  }

  public String getValue() {
      return value;
  }
}
