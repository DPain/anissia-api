package main;

import java.time.LocalDateTime;

/**
 * Subtitle
 * 
 * @author DPain
 *
 */
public class Subtitle {
  public Episode episode;
  public LocalDateTime updateDateTime;
  public String link;
  public String name;

  @Override
  public String toString() {
    return String.format("Subtitle [episode=%s, updateTime=%s, link=%s, name=%s]", episode,
        updateDateTime, link, name);
  }
}
