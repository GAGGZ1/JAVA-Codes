class Stack {
  int[] arr;
  int top;

  Stack(int capacity) {
      arr = new int[capacity];
      top = -1;
  }

  // Push an element
  void push(int x) {
      if (top == arr.length - 1) {
          System.out.println("Stack full");
          return;
      }
      arr[++top] = x;
  }

  // Pop an element
  int pop() {
      if (top == -1) {
          System.out.println("Stack empty");
          return -1;
      }
      return arr[top--];
  }

  // Display the stack
  void display() {
      for (int i = 0; i <= top; i++) {
          System.out.print(arr[i] + " ");
      }
      System.out.println();
  }
}
