package tries;

import java.util.HashMap;
import java.util.Map;

public class PopulateSuffixTrieFrom {
  static class TrieNode {
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  }

  static class SuffixTrie {
    TrieNode root = new TrieNode();
    char endSymbol = '*';

    public SuffixTrie(String str) {
      populateSuffixTrieFrom(str);
    }

    public void populateSuffixTrieFrom(String str) {
      for (int i = 0; i < str.length(); i++) {
        String subString = str.substring(i);
        TrieNode node = root;

        for (Character ch :
            subString.toCharArray()) {
          if (!node.children.containsKey(ch)) {
            node.children.put(ch, new TrieNode());
          }
          node = node.children.get(ch);
        }

        node.children.put(endSymbol, null);

      }
    }

    public boolean contains(String str) {
      TrieNode node = root;
      for (Character ch :
          str.toCharArray()) {
        if (!node.children.containsKey(ch)) return false;

        node = node.children.get(ch);
      }


      return node.children.containsKey(endSymbol);
    }
  }
}
