package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CaesarCypherEncryptor {

  public static void main(String[] args) {
    System.out.println(caesarCypherEncryptor("mvklahvjcnbwqvtutmfafkwiuagjkzmzwgf", 7));
  }
  public static String caesarCypherEncryptor(String str, int key) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c = 'a'; c <= 'z'; c++) {
      map.put(c, c - 'a' + 1);
    }

    int updatedKey = key % 26;
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      int uKey = map.get(str.charAt(i)) + updatedKey;
      if (uKey > 26) {
        int newKey = (uKey) % 26;
        Character key1 = map.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), newKey)).findFirst().get().getKey();
        stringBuilder.append(key1);
      } else {
        Character key1 = map.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), uKey)).findFirst().get().getKey();
        stringBuilder.append(key1);
      }
    }
    return stringBuilder.toString();
  }
}
