package strings;

import java.util.HashMap;
import java.util.Map;

public class PatternMatcher {
  public static String[] patternMatcher(String pattern, String str) {
    if (pattern.length() > str.length()) return new String[]{};
    var newPattern = getNewPattern(pattern);
    boolean isReversed = newPattern.charAt(0) == pattern.charAt(0) ? false : true;
    var yIndexFirstPosition = getFirstIndexOfY(newPattern);
    var frequencyMap = createFrequencyMap(newPattern);

    var lenOfStr = str.length();
    if (yIndexFirstPosition != -1) {

      for (int xLength = 1; xLength < lenOfStr; xLength++) {
        int yLength = (lenOfStr - (frequencyMap.get('x') * xLength)) / frequencyMap.get('y');
        if (yLength <= 0 || yLength % 1 != 0) continue;
        var yIndexInSubstring = yIndexFirstPosition * xLength;
        var xSubstring = str.substring(0, xLength);
        var ySubstring = str.substring(yIndexInSubstring, yIndexInSubstring + yLength);
        var generatedPattern = generatePatternFromString(newPattern, xSubstring, ySubstring);
        if (generatedPattern.equals(str)) {
          return isReversed ? new String[]{ySubstring, xSubstring} : new String[]{xSubstring, ySubstring};
        }
      }
    } else {
      int xLength = lenOfStr / frequencyMap.get('x');
      if (xLength % 1 == 0) {
        var xSubstring = str.substring(0, xLength);
        var generatedPattern = generatePatternFromString(newPattern, xSubstring, null);
        if (generatedPattern.equals(str)) {
          return isReversed ? new String[]{"", xSubstring} : new String[]{xSubstring, ""};
        }
      }
    }
    return new String[]{};
  }

  private static String generatePatternFromString(String pattern, String xSubstring, String ySubstring) {

    StringBuilder patternStringBuilder = new StringBuilder();
    for (int i = 0; i < pattern.length(); i++) {
      if (pattern.charAt(i) == 'x') patternStringBuilder.append(xSubstring);
      else {
        if (ySubstring != null) patternStringBuilder.append(ySubstring);
      }
    }

    return patternStringBuilder.toString();
  }

  private static Map<Character, Integer> createFrequencyMap(String pattern) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
    }
    return map;
  }

  private static int getFirstIndexOfY(String pattern) {
    for (int i = 0; i < pattern.length(); i++) {
      if (pattern.charAt(i) == 'y') return i;
    }
    return -1;
  }

  private static String getNewPattern(String pattern) {
    char[] patternArray = pattern.toCharArray();
    if (pattern.charAt(0) == 'x') return pattern;
    for (int i = 0; i < patternArray.length; i++) {
      if (patternArray[i] == 'y') patternArray[i] = 'x';
      else patternArray[i] = 'y';
    }

    return String.valueOf(patternArray);
  }
}
