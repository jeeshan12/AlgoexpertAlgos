package tries;

import java.util.HashMap;
import java.util.Map;

public class LongestMostFrequentPrefix {

  static class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    int count = 0;
  }

  static class Trie {
    TrieNode root = new TrieNode();
    int maxPrefixCount = 0;
    int maxPrefixLength = 0;

    String maxPrefixFullString = "";

    public void insert(String str) {
      TrieNode node = root;
      for (int i= 0; i < str.length(); i++) {
        char ch = str.charAt(i);

        if (!node.children.containsKey(ch)) {
          TrieNode newNode = new TrieNode();
          node.children.put(ch, newNode);
        }

        node = node.children.get(ch);
        node.count++;

        if (node.count > this.maxPrefixCount) {
          this.maxPrefixCount = node.count;
          this.maxPrefixLength = i +1;
          this.maxPrefixFullString = str;
        } else if (node.count == this.maxPrefixCount && i+1 > maxPrefixLength) {
          this.maxPrefixLength = i +1;
          this.maxPrefixFullString = str;
        }
      }

    }
  }
  public String longestMostFrequentPrefix(String[] strings) {
    Trie trie = new Trie();
    for (String str: strings) {
      trie.insert(str);
    }
    return trie.maxPrefixFullString.substring(0, trie.maxPrefixLength);
  }
}
