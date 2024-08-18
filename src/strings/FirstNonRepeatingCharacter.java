package strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

class FirstNonRepeatingCharacter {
  public static class Pair {
    public Pair(int index, int feq) {
      this.index = index;
      this.feq = feq;
    }
    int index;
    int feq;

  }

  public int firstNonRepeatingCharacter(String string) {
    if (string.isEmpty()) return -1;
    Map<Character, Pair> map = new LinkedHashMap<>();

    for (int i = 0; i < string.length(); i++) {
      char ch = string.charAt(i);
      if (map.containsKey(ch)) {
        Pair pair = map.get(ch);
        pair.feq++;
        map.put(ch, pair);
      }else {
        map.put(ch, new Pair(i, 1));
      }
    }

    Optional<Entry<Character, Pair>> optionalMap = map.entrySet().stream().filter(entry -> entry.getValue().feq == 1).findFirst();
    return optionalMap.map(characterPairEntry -> characterPairEntry.getValue().index).orElse(-1);
  }
}
