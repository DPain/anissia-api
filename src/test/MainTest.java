package test;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Test;
import main.Anime;
import main.AnissiaAPI;
import main.enums.Category;

public class MainTest {
  
  @Test
  public void mondayTest() {
    AnissiaAPI api = new AnissiaAPI();
    
    LinkedList<Anime> result = null;
    try {
      result = api.getCategoryInfo(Category.MONDAY);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    System.out.println(Arrays.toString(result.toArray()));
  }
}
