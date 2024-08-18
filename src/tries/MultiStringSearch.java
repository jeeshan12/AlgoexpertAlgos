package tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiStringSearch {
  static class TrieNode {
    Map<Character, TrieNode> children;

    char endSymbol = '*';

    public TrieNode() {
      children = new HashMap<Character, TrieNode>();
    }

  }

  public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
    TrieNode node = new TrieNode();
    for (int i = 0; i < bigString.length(); i++) {
      populateSuffixTrieFrom(bigString.substring(i), node);
    }

    List<Boolean> list = new ArrayList<>();

    for (String smallString :
        smallStrings) {

      boolean isExist = searchSmallString(smallString, node);
      list.add(isExist);

    }
    return list;
  }

  private static boolean searchSmallString(String smallString, TrieNode root) {
    TrieNode node = root;
    for (Character ch :
        smallString.toCharArray()) {
      if (!node.children.containsKey(ch)) return false;
      node = node.children.get(ch);


    }

    return true;
  }

  private static void populateSuffixTrieFrom(String substring, TrieNode root) {
    TrieNode node = root;
    for (Character ch :
        substring.toCharArray()) {
      if (!node.children.containsKey(ch)) {
        node.children.put(ch, new TrieNode());
      }

      node = node.children.get(ch);
    }

    node.children.put(node.endSymbol, null);
  }
}
