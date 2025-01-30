class Trie {
  private Node root;

  static class Node {
      Node[] children;
      boolean isEndOfWord;

      Node() {
          children = new Node[26];  // For lowercase English letters
          isEndOfWord = false;
      }
  }

  Trie() {
      root = new Node();
  }

  // Insert a word into the Trie
  void insert(String word) {
      Node node = root;
      for (char c : word.toCharArray()) {
          if (node.children[c - 'a'] == null) {
              node.children[c - 'a'] = new Node();
          }
          node = node.children[c - 'a'];
      }
      node.isEndOfWord = true;
  }

  // Search for a word in the Trie
  boolean search(String word) {
      Node node = root;
      for (char c : word.toCharArray()) {
          if (node.children[c - 'a'] == null) {
              return false;
          }
          node = node.children[c - 'a'];
      }
      return node.isEndOfWord;
  }
}
