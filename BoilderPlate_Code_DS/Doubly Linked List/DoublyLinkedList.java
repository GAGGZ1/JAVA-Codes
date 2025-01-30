class DoublyLinkedList {
  Node head;

  static class Node {
      int data;
      Node next, prev;

      Node(int data) {
          this.data = data;
          this.next = this.prev = null;
      }
  }

  // Insert at the end
  void insert(int data) {
      Node newNode = new Node(data);
      if (head == null) {
          head = newNode;
      } else {
          Node temp = head;
          while (temp.next != null) {
              temp = temp.next;
          }
          temp.next = newNode;
          newNode.prev = temp;
      }
  }

  // Display the list
  void display() {
      Node temp = head;
      while (temp != null) {
          System.out.print(temp.data + " ");
          temp = temp.next;
      }
      System.out.println();
  }
}
