package baekjoon.b1927;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
  static class MinHeap {
    private List<Integer> heap;
    private Comparator<Integer> comparator;

    public MinHeap(Comparator<Integer> comparator) {
      this.heap = new ArrayList<>();
      this.comparator = comparator;
    }

    public void insert(int value) {
      heap.add(value);
      heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int index) {
      while (index > 0) {
        int parentIndex = (index - 1) / 2;
        if (comparator.compare(heap.get(parentIndex), heap.get(index)) <= 0) break;
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

        if (left < heap.size() && heap.get(left) < heap.get(smallest))
          smallest = left;
        if (right < heap.size() && heap.get(right) < heap.get(smallest))
          smallest = right;
        if (smallest == index) break;
        swap(index, smallest);
        index = smallest;
      }
    }

    public int size() {
      return heap.size();
    }

    private void swap(int i, int j) {
      int temp = heap.get(i);
      heap.set(i, heap.get(j));
      heap.set(j, temp);
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(reader.readLine());
      MinHeap heap = new MinHeap();
      for (int i = 0; i < N; ++i) {
          int a = Integer.parseInt(reader.readLine());
          if (a > 0) heap.insert(a);
          else
              System.out.println(heap.size() > 0 ? heap.remove() : 0);
      }
  }
}
