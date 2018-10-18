package test;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Test;
import main.Anime;
import main.AnissiaAPI;
import main.Subtitle;
import main.enums.Category;

public class MainTest {
  AnissiaAPI api;

  public MainTest() {
    api = new AnissiaAPI();
  }
  
  @Test
  public void mondayTest() {
    LinkedList<Anime> result = null;
    try {
      result = api.getCategoryInfo(Category.MONDAY);

      System.out.println(Arrays.toString(result.toArray()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void subtitleTest() {
    // 코드 기어스 = 4289 yields []
    // 소아온 = 4075 not [] 
    
    LinkedList<Subtitle> result = null;
    try {
      result = api.getSubtitleInfo(4075);

      System.out.println(Arrays.toString(result.toArray()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
