class BinarySearchTree {
  Node root;

  static class Node {
      int data;
      Node left, right;

      Node(int data) {
          this.data = data;
          left = right = null;
      }
  }

  // Insert a node
  void insert(int data) {
      root = insertRec(root, data);
  }

  Node insertRec(Node root, int data) {
      if (root == null) {
          root = new Node(data);
          return root;
      }
      if (data < root.data)
          root.left = insertRec(root.left, data);
      else if (data > root.data)
          root.right = insertRec(root.right, data);

      return root;
  }

  // In-order traversal
  void inorder() {
      inorderRec(root);
      System.out.println();
  }

  void inorderRec(Node root) {
      if (root != null) {
          inorderRec(root.left);
          System.out.print(root.data + " ");
          inorderRec(root.right);
      }
  }
}
