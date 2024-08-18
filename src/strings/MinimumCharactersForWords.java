package strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumCharactersForWords {

  public char[] minimumCharactersForWords(String[] words) {
    Map<Character, Integer> map = new HashMap<>();
    for (String word :
        words) {
      Map<Character, Integer> wordsMap = new HashMap<>();
      for (int i = 0; i < word.length(); i++) {
        wordsMap.put(word.charAt(i), wordsMap.getOrDefault(word.charAt(i), 0) + 1);
      }
      for (Map.Entry<Character, Integer> entry : wordsMap.entrySet()) {
        char key = entry.getKey();
        int value = entry.getValue();
        if (!map.containsKey(key)) map.put(key, value);
        else {
          if (map.get(key) < value) map.put(key, value);
        }
      }
    }
    int size = map.values()
        .stream()
        .reduce(0, (a, b) -> a + b);
    char[] chars = new char[size];

    int idx = 0;
    System.out.println(map);
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      char key = entry.getKey();
      int value = entry.getValue();

      for (int i = 0; i < value; i++) {
        chars[idx++] = key;
      }
    }
    System.out.println(String.valueOf(chars));
    return chars;
  }

}
