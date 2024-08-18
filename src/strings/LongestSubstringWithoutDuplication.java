package strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplication {


  public static void main(String[] args) {
    System.out.println(longestSubstringWithoutDuplication("abccdeaabbcddef"));
  }
  public static String longestSubstringWithoutDuplication(String str) {
    if (str.isEmpty() || str.length() == 1) return str;

    int i = 0;
    int j = 0;
    int max = Integer.MIN_VALUE;

    Map<Character, Integer> map = new LinkedHashMap<>();

    int start = 0;
    int end = 0;
    while (j < str.length()) {
      map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) +1);
      long count = map.entrySet().stream().filter(entry -> entry.getValue() > 1).count();
      if (count == 0) {
        if (map.size() > max) {
          max = map.size();
          start = i;
          end = j +1;

        }
      } else if (count > 0) {
        while (count != 0) {
          map.put(str.charAt(i), map.get(str.charAt(i)) -1);
          if (map.get(str.charAt(i)) == 0) {
            map.remove(str.charAt(i));
          }
          i++;
          count = map.entrySet().stream().filter(entry -> entry.getValue() > 1).count();
        }
      }
      j++;
    }
    return str.substring(start, end);
  }
}
