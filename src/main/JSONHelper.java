package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import org.json.JSONException;
import org.json.JSONObject;
import main.enums.AnimeKey;

public class JSONHelper {

  public static Anime toAnime(JSONObject obj) throws JSONException {
    Anime output = new Anime();

    output.id = obj.getInt(AnimeKey.ID.toString());
    output.name = obj.getString(AnimeKey.NAME.toString());

    try {
      String key = obj.getString(AnimeKey.TIME.toString());
      StringBuilder temp = new StringBuilder(key).insert(2, ":");
      output.time = LocalTime.parse(temp);
    } catch (DateTimeParseException e) {
      output.time = null;
    }

    output.genre = obj.getString(AnimeKey.GENRE.toString());
    output.link = obj.getString(AnimeKey.LINK.toString()).trim();
    output.onAir = obj.getBoolean(AnimeKey.ON_AIR.toString());

    try {
      String key = obj.getString(AnimeKey.START_DATE.toString());
      StringBuilder temp = new StringBuilder(key).insert(4, "-").insert(7, "-");
      output.startDate = LocalDate.parse(temp);
    } catch (DateTimeParseException e) {
      output.startDate = null;
    }

    try {
      String key = obj.getString(AnimeKey.END_DATE.toString());
      StringBuilder temp = new StringBuilder(key).insert(4, "-").insert(7, "-");
      output.endDate = LocalDate.parse(temp);
    } catch (DateTimeParseException e) {
      output.endDate = null;
    }

    return output;
  }
}
