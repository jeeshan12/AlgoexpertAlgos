package strings;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringContaining {
  public static String smallestSubstringContaining(String bigString, String smallString) {
    if (smallString.length() > bigString.length()) return "";
    Map<Character, Integer> map = new HashMap<>();
    for (char ch :
        smallString.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    int uniqueCharacters = 0;
    int left = 0, right = 0;
    String str = "";
    int uniqueKeys = map.keySet().size();
    Map<Character, Integer> substringMap = new HashMap<>();
    while (right < bigString.length()) {
      char ch = bigString.charAt(right);
      if (!map.containsKey(ch)) {
        right++;
        continue;
      }
      substringMap.put(ch, substringMap.getOrDefault(ch, 0) + 1);

      if (substringMap.get(ch) == map.get(ch)) uniqueCharacters++;

      while (uniqueCharacters == uniqueKeys && left <= right) {
        if (str.isEmpty()) {
          str = bigString.substring(left, right + 1);
        }
        else if( right + 1 - left < str.length()) {
          str = bigString.substring(left, right + 1);
        }
        char leftChar = bigString.charAt(left);
        if (!map.containsKey(leftChar)) {
          left++;
          continue;
        }
        if (substringMap.get(leftChar) == map.get(leftChar)) {
          uniqueCharacters--;
        }

        if (substringMap.get(leftChar) != 0) {
          substringMap.put(leftChar, substringMap.get(leftChar) - 1);
        }

        left++;
      }
      right++;
    }

    System.out.println(str);

    return str;
  }
}
