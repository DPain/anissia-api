package main;

import java.time.LocalDate;
import java.time.LocalTime;

public class Anime {
  public int id;
  public String name;
  public LocalTime time;
  public String genre;
  public String link;
  public boolean onAir;
  public LocalDate startDate;
  public LocalDate endDate;

  @Override
  public String toString() {
    String temp = "NONE";
    if (endDate != null) {
      temp = endDate.toString();
    }
    return String.format(
        "Anime [id=%d, name=%s, time=%s, genre=%s, link='%s', onAir=%s, startDate=%s, endDate=%s]",
        id, name, time, genre, link, onAir, startDate, temp);
  }
}
