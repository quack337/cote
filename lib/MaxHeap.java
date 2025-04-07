import java.util.ArrayList;
import java.util.List;

class MaxHeap {
  private List<Integer> heap;

  public MaxHeap() {
    this.heap = new ArrayList<>();
  }

  public void insert(int value) {
    heap.add(value);
    heapifyUp(heap.size() - 1);
  }

  private void heapifyUp(int index) {
    while (index > 0) {
      int parentIndex = (index - 1) / 2;
      if (heap.get(parentIndex) >= heap.get(index)) break;
      swap(parentIndex, index);
      index = parentIndex;
    }
  }

  public int remove() {
    if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
    int max = heap.get(0);
    int end = heap.remove(heap.size() - 1);
    if (!heap.isEmpty()) {
      heap.set(0, end);
      heapifyDown(0);
    }
    return max;
  }

  private void heapifyDown(int index) {
    while (index < heap.size()) {
      int left = 2 * index + 1;
      int right = 2 * index + 2;
      int largest = index;

      if (left < heap.size() && heap.get(left) > heap.get(largest)) {
        largest = left;
      }
      if (right < heap.size() && heap.get(right) > heap.get(largest)) {
        largest = right;
      }
      if (largest == index) break;
      swap(index, largest);
      index = largest;
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
    MaxHeap heap = new MaxHeap();
    for (int i = 0; i < 50; i++) {
      int randomValue = (int) (Math.random() * 100);
      heap.insert(randomValue);
    }
    List<Integer> result = new ArrayList<>();
    while (!heap.isEmpty())
      result.add(heap.remove());
    System.out.println(result);
  }
}
