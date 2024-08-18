package strings;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString {
  public String reverseWordsInString(String string) {
    List<String> li = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < string.length(); i++) {
      if (i == string.length() - 1 && string.charAt(i) != ' ') {
        li.add(stringBuilder.append(string.charAt(i)).toString());
        stringBuilder.setLength(0);
      } else if (string.charAt(i) != ' ') {
        stringBuilder.append(string.charAt(i));
      } else {
        li.add(stringBuilder.toString());
        li.add(" ");
        stringBuilder.setLength(0);
      }
    }
    stringBuilder.setLength(0);
    for (int i = li.size() - 1; i >= 0; i--) {
      stringBuilder.append(li.get(i));
    }
    return stringBuilder.toString();
  }

  public String reverseWordsInString2(String string) {
    if (string.length() == 0) return "";

    char[] chars = string.toCharArray();
    int start = 0;
    int end = string.length() - 1;
    reverseString(chars, start, end);
    int startPoint = 0;
    while (true) {
      int endpoint = startPoint;

      while (endpoint < chars.length && chars[endpoint] != ' '){
        endpoint++;
      }
      if (endpoint == chars.length) {
        reverseString(chars, startPoint, endpoint-1);
        break;
      }
      reverseString(chars, startPoint, endpoint-1);
      startPoint = endpoint + 1;
    }
    return String.valueOf(chars);
  }

  public static void reverseString(char[] string, int start, int end) {
    while (start < end) {
      char tmp = string[start];
      string[start] = string[end];
      string[end] = tmp;
      start++;
      end--;
    }
  }
}
