package baekjoon.b11286;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main3 {

  static class AbsoluteMinHeap {
    private List<Integer> heap;

    public AbsoluteMinHeap() {
      this.heap = new ArrayList<>();
    }

    public void insert(int value) {
      heap.add(value);
      heapifyUp(heap.size() - 1);
    }

    private int compare(int a, int b) {
      int r = Math.abs(a) - Math.abs(b);
      if (r != 0) return r;
      return a - b;
    }

    private void heapifyUp(int index) {
      while (index > 0) {
        int parentIndex = (index - 1) / 2;
        if (compare(heap.get(parentIndex), heap.get(index)) <= 0) break;
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
        if (left < heap.size() && compare(heap.get(left), heap.get(smallest)) < 0)
          smallest = left;
        if (right < heap.size() && compare(heap.get(right), heap.get(smallest)) < 0)
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
      AbsoluteMinHeap heap = new AbsoluteMinHeap();
      for (int i = 0; i < N; ++i) {
          int a = Integer.parseInt(reader.readLine());
          if (a != 0) heap.insert(a);
          else
              System.out.println(heap.size() > 0 ? heap.remove() : 0);
      }
  }
}
