class MinHeap {
  int[] heap;
  int size;
  int capacity;

  MinHeap(int capacity) {
      this.capacity = capacity;
      this.size = 0;
      heap = new int[capacity];
  }

  // Insert a value
  void insert(int val) {
      if (size == capacity) {
          System.out.println("Heap full");
          return;
      }
      heap[size] = val;
      int current = size;
      while (heap[current] < heap[(current - 1) / 2]) {
          swap(current, (current - 1) / 2);
          current = (current - 1) / 2;
      }
      size++;
  }

  // Heapify the heap
  void heapify(int index) {
      int smallest = index;
      int leftChild = 2 * index + 1;
      int rightChild = 2 * index + 2;

      if (leftChild < size && heap[leftChild] < heap[smallest]) {
          smallest = leftChild;
      }
      if (rightChild < size && heap[rightChild] < heap[smallest]) {
          smallest = rightChild;
      }

      if (smallest != index) {
          swap(index, smallest);
          heapify(smallest);
      }
  }

  // Swap two elements
  void swap(int i, int j) {
      int temp = heap[i];
      heap[i] = heap[j];
      heap[j] = temp;
  }

  // Print the heap
  void printHeap() {
      for (int i = 0; i < size; i++) {
          System.out.print(heap[i] + " ");
      }
      System.out.println();
  }
}
