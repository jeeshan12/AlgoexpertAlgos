package strings;

import java.util.ArrayList;
import java.util.List;

public class UnderscorifySubstring {
  public static String underscorifySubstring(String str, String substring) {
    List<int[]> list = new ArrayList<>();
    int startIndex = 0;
    while (startIndex < str.length()) {
      var index = str.indexOf(substring, startIndex);
      if (index != -1) {
        list.add(new int[]{index, index + substring.length()});
      } else {
        break;
      }
      startIndex = index + 1;
    }
    if (list.isEmpty()) return str;

    int listIndex = 1;
    List<int[]> collapsedList = new ArrayList<>();
    collapsedList.add(list.getFirst());
    int[] previousIndexes = collapsedList.getFirst();
    while (listIndex < list.size()) {
      int[] currentIndexes = list.get(listIndex);
      if (list.get(listIndex)[0] <= previousIndexes[1]) {
        previousIndexes[1] = list.get(listIndex)[1];
      } else {
        collapsedList.add(list.get(listIndex));
        previousIndexes = currentIndexes;
      }
      listIndex++;
    }
    List<String> finalWordsList = new ArrayList<>();
    int locationIndex = 0;
    for (int[] locIndex : collapsedList) {
      if (locIndex[0] != 0) finalWordsList.add(str.substring(locationIndex, locIndex[0]));
      finalWordsList.add("_");
      finalWordsList.add(str.substring(locIndex[0], locIndex[1]));
      finalWordsList.add("_");
      locationIndex = locIndex[1];
    }
    if (locationIndex < str.length()) finalWordsList.add(str.substring(locationIndex));
    return String.join("", finalWordsList);
  }
}
