package lib;
import java.util.ArrayList;
import java.util.List;

class MinHeap {
  private List<Integer> heap;

  public MinHeap() {
    this.heap = new ArrayList<>();
  }

  public void insert(int value) {
    heap.add(value);
    heapifyUp(heap.size() - 1);
  }

  private void heapifyUp(int index) {
    while (index > 0) {
      int parentIndex = (index - 1) / 2;
      if (heap.get(parentIndex) <= heap.get(index)) break;
      swap(parentIndex, index);
      index = parentIndex;
    }
  }

  public int remove() {
    if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
    int min = heap.get(0);
    int end = heap.remove(heap.size() - 1);
    if (!heap.isEmpty()) {
      heap.set(0, end);
      heapifyDown(0);
    }
    return min;
  }

  private void heapifyDown(int index) {
    while (index < heap.size()) {
      int left = 2 * index + 1;
      int right = 2 * index + 2;
      int smallest = index;

      if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
        smallest = left;
      }
      if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
        smallest = right;
      }
      if (smallest == index) break;
      swap(index, smallest);
      index = smallest;
    }
  }

  public boolean isEmpty() {
    return heap.isEmpty();
  }

  private void swap(int i, int j) {
    int temp = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, temp);
  }

  public static void main(String[] args) {
    MinHeap heap = new MinHeap();
    for (int i = 0; i < 50; i++) {
      int randomValue = (int) (Math.random() * 100);
      heap.insert(randomValue);
    }
    List<Integer> result = new ArrayList<>();
    while (!heap.isEmpty()) {
      result.add(heap.remove());
    }
    System.out.println(result);
  }
}