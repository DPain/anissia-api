package main;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.json.JSONException;
import org.json.JSONObject;
import main.enums.AnimeKey;
import main.enums.SubtitleKey;

public class JSONHelper {
  public static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");
  public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
  public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

  public static Anime toAnime(JSONObject obj) throws JSONException, ParseException {
    Anime output = new Anime();

    output.id = obj.getInt(AnimeKey.ID.toString());
    output.name = obj.getString(AnimeKey.NAME.toString());

    try {
      String str = obj.getString(AnimeKey.TIME.toString());
      output.time = LocalTime.parse(str, timeFormatter);
    } catch (DateTimeParseException e) {
      output.time = null;
    }

    output.genre = obj.getString(AnimeKey.GENRE.toString());
    output.link = obj.getString(AnimeKey.LINK.toString()).trim();
    output.onAir = obj.getBoolean(AnimeKey.ON_AIR.toString());

    try {
      String str = obj.getString(AnimeKey.START_DATE.toString());
      output.startDate = LocalDate.parse(str, dateFormatter);
    } catch (DateTimeParseException e) {
      output.startDate = null;
    }

    try {
      String str = obj.getString(AnimeKey.END_DATE.toString());
      output.endDate = LocalDate.parse(str, dateFormatter);
    } catch (DateTimeParseException e) {
      output.endDate = null;
    }

    return output;
  }

  public static Subtitle toSubtitle(JSONObject obj) throws JSONException, ParseException {
    Subtitle output = new Subtitle();

    output.episode = AnissiaAPI.getEpisode(obj.getString(SubtitleKey.EPISODE.toString()));

    try {
      String str = obj.getString(SubtitleKey.DATETIME.toString());
      output.updateDateTime = LocalDateTime.parse(str, dateTimeFormatter);
    } catch (DateTimeParseException e) {
      output.updateDateTime = null;
    }

    output.link = obj.getString(SubtitleKey.LINK.toString());
    output.name = obj.getString(SubtitleKey.NAME.toString());

    return output;
  }
}
