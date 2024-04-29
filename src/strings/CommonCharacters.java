package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommonCharacters {


  public static void main(String[] args) {
    CommonCharacters commonCharacters = new CommonCharacters();
    System.out.println(
        Arrays.toString(
            commonCharacters.commonCharacters(new String[]{"aa", "aa"})
    ));
  }

  public String[] commonCharacters(String[] strings) {

    if (strings.length == 1) return strings[0].split("");

    Map<String, Integer> frequencyMap = new HashMap<>();

    for (String str : strings) {
      Set<Character> characterSet = new HashSet<>();
      for (int i = 0; i < str.length(); i++) {
          if (!characterSet.contains(str.charAt(i))) {
            String currentString = String.valueOf(str.charAt(i));
            characterSet.add(str.charAt(i));
            frequencyMap.put(currentString, frequencyMap.getOrDefault(currentString, 0)+1);
          }
      }
    }

    Set<String> uniqueCharacterSet = new HashSet<>();
   for (String str : frequencyMap.keySet()) {
     if (frequencyMap.get(str) == strings.length) {
       uniqueCharacterSet.add(str);
     }
   }

    return uniqueCharacterSet.toArray(new String[0]);
  }

}
