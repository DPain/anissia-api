package main;

import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import main.enums.Category;


public class AnissiaAPI {
  private final String categoryAddress = "https://www.anissia.net/anitime/list?w=";
  private final String subtitleAddress = "https://www.anissia.net/anitime/cap?i=";

  public AnissiaAPI() {

  }

  public LinkedList<Anime> getCategoryInfo(Category cat)
      throws IOException, JSONException, ParseException {
    LinkedList<Anime> result = new LinkedList<Anime>();

    StringBuilder builder = new StringBuilder(categoryAddress).append(cat.getParam());
    String resp = AnissiaAPI.sendGetResponse(builder.toString());
    JSONArray jArray = new JSONArray(resp);

    Iterator<Object> iter = jArray.iterator();
    while (iter.hasNext()) {
      JSONObject obj = (JSONObject) iter.next();
      Anime anime = JSONHelper.toAnime(obj);
      result.add(anime);
    }

    return result;
  }

  public LinkedList<Subtitle> getSubtitleInfo(int id)
      throws IOException, JSONException, ParseException {
    LinkedList<Subtitle> result = new LinkedList<Subtitle>();

    StringBuilder builder = new StringBuilder(subtitleAddress).append(id);
    String resp = AnissiaAPI.sendGetResponse(builder.toString());
    JSONArray jArray = new JSONArray(resp);
    Iterator<Object> iter = jArray.iterator();
    while (iter.hasNext()) {
      JSONObject obj = (JSONObject) iter.next();
      Subtitle subtitle = JSONHelper.toSubtitle(obj);
      result.add(subtitle);
    }

    return result;
  }

  public static Episode getEpisode(String str) throws ParseException {
    Episode episode = new Episode();

    try {
      episode.num = Integer.parseInt(str.substring(0, 4));
    } catch (NumberFormatException e) {
      episode.num = 0;
      // #TODO Implement Episode Type
    }

    episode.subNum = Integer.parseInt(str.substring(4));

    return episode;
  }

  public static String sendGetResponse(String resp) throws IOException {
    String output;

    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpGet httpget = new HttpGet(resp);

      // Sending request
      httpget.getRequestLine();

      // Create a custom response handler
      ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
        @Override
        public String handleResponse(HttpResponse arg0) throws IOException {
          String result = "";
          int code = arg0.getStatusLine().getStatusCode();
          if (code == 200) {
            // Request was successful
            HttpEntity entity = arg0.getEntity();
            result = EntityUtils.toString(entity);
          }
          return result;
        }
      };

      output = httpclient.execute(httpget, responseHandler);
    } finally {
      httpclient.close();
    }
    return output;
  }
}
