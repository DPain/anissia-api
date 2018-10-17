package main;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import main.enums.Category;


public class AnissiaAPI {
  private final String categoryAddress = "https://www.anissia.net/anitime/list?w=";
  private final String subtitleAddress = "https://www.anissia.net/anitime/cap?i=";

  public AnissiaAPI() {

  }

  public LinkedList<Anime> getCategoryInfo(Category cat) throws Exception {
    LinkedList<Anime> result = new LinkedList<Anime>();
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpGet httpget = new HttpGet(categoryAddress + cat.getParam());

      // Sending request
      httpget.getRequestLine();

      // Create a custom response handler
      ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
        @Override
        public String handleResponse(HttpResponse arg0)
            throws ClientProtocolException, IOException {
          int code = arg0.getStatusLine().getStatusCode();
          if (code == 200) {
            // Request was successful
            HttpEntity entity = arg0.getEntity();

            return entity != null ? EntityUtils.toString(entity) : null;
          } else if (code == 404) {
            // Server is down
            throw new IOException("Server is down!");
          } else {
            throw new IOException("Unknown Error!");
          }
        }
      };
      String responseBody = httpclient.execute(httpget, responseHandler);

      JSONArray jArray = new JSONArray(responseBody);

      Iterator<Object> iter = jArray.iterator();
      while (iter.hasNext()) {
        JSONObject obj = (JSONObject) iter.next();
        Anime anime = JSONHelper.toAnime(obj);
        result.add(anime);
      }
    } finally {
      httpclient.close();
    }

    return result;
  }
}
