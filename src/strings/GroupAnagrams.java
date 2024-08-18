package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  public static List<List<String>> groupAnagrams(List<String> words) {
    Map<Map<Character, Integer>, List<String>> dMap = new HashMap<>();

    for (String word : words) {
      Map<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < word.length(); i++) {
        map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
      }
      if (!dMap.containsKey(map)) {
        List<String> strings = new ArrayList<>();
        strings.add(word);
        dMap.put(map, strings);
      } else {
        List<String> strings = dMap.get(map);
        strings.add(word);
        dMap.put(map, strings);

      }

    }

    return new ArrayList<>(dMap.values());
  }
}
