class Queue {
  int[] arr;
  int front, rear, size;

  Queue(int capacity) {
      arr = new int[capacity];
      front = rear = -1;
      size = 0;
  }

  // Enqueue
  void enqueue(int x) {
      if (size == arr.length) {
          System.out.println("Queue full");
          return;
      }
      if (front == -1) {
          front = 0;
      }
      rear = (rear + 1) % arr.length;
      arr[rear] = x;
      size++;
  }

  // Dequeue
  int dequeue() {
      if (size == 0) {
          System.out.println("Queue empty");
          return -1;
      }
      int x = arr[front];
      front = (front + 1) % arr.length;
      size--;
      return x;
  }

  // Display the queue
  void display() {
      for (int i = 0; i < size; i++) {
          System.out.print(arr[(front + i) % arr.length] + " ");
      }
      System.out.println();
  }
}
