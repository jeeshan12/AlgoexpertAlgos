package strings;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {


  public static void main(String[] args) {
    System.out.println(generateDocument("aheaollabbhb", "hello"));
  }

  public static boolean generateDocument(String characters, String document) {
    if (document.isEmpty()) return true;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < characters.length(); i++) {
      map.put(characters.charAt(i), map.getOrDefault(characters.charAt(i), 0) + 1);
    }
    for (int i = 0; i < document.length(); i++) {
      if (!map.containsKey(document.charAt(i))) return false;
      if (map.containsKey(document.charAt(i))) {
        map.put(document.charAt(i), map.get(document.charAt(i)) -1);
        if (map.get(document.charAt(i)) == 0) {
          map.remove(document.charAt(i));
        }
      }
    }
    return true;
  }
}
