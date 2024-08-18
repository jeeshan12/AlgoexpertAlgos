package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Semordnilap {
  public ArrayList<ArrayList<String>> semordnilap(String[] words) {
    ArrayList<ArrayList<String>> finalList = new ArrayList<>();

    if(words.length == 0) return finalList;

    Map<String, ArrayList<String>> map = new HashMap<>();

    for (String word : words) {
      String reversedString = reverseString(word);
      if (map.containsKey(reversedString)) {
        ArrayList<String> wordList = map.get(reversedString);
        wordList.add(word);
      } else {
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add(word);
        map.put(word, wordList);
      }
    }


    for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
      if (entry.getValue().size() > 1) {
        finalList.add(entry.getValue());

      }
    }
    return finalList;
  }


  private static String reverseString(String word) {
    char[] chars = word.toCharArray();
    int left = 0;
    int right = chars.length - 1;
    while (left < right) {
      char temp = chars[left];
      chars[left] = chars[right];
      chars[right] = temp;
      left++;
      right--;
    }
    return String.valueOf(chars);
  }
}
