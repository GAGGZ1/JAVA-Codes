import java.util.*;
class HashMap {
  private int[] map;
  private final int capacity = 10;

  HashMap() {
      map = new int[capacity];
      Arrays.fill(map, -1); // -1 denotes an empty slot
  }

  // Hash function
  private int hash(int key) {
      return key % capacity;
  }

  // Insert a key
  void insert(int key) {
      int index = hash(key);
      while (map[index] != -1) {
          index = (index + 1) % capacity;  // Linear probing
      }
      map[index] = key;
  }

  // Search for a key
  boolean search(int key) {
      int index = hash(key);
      while (map[index] != -1) {
          if (map[index] == key) {
              return true;
          }
          index = (index + 1) % capacity;
      }
      return false;
  }

  // Print the map
  void print() {
      for (int i = 0; i < capacity; i++) {
          if (map[i] != -1) {
              System.out.print(map[i] + " ");
          }
      }
      System.out.println();
  }
}

