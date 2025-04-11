package baekjoon.b2014;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main4 {
    static class MinHeap {
        long[] a;
        int count = 0;

        public MinHeap(int size) {
            a = new long[size];
        }

        private int parent(int index) {
            if (index == 0) return 0;
            return (index - 1) / 2;
        }

        private int left(int index) { return 2 * index + 1; }
        private int right(int index) { return 2 * index + 2; }

        private void swap(int i, int j) {
            long temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        private void heapifyUp(int i) {
            if (i == 0) return;
            int parent = parent(i);
            if (a[parent] > a[i])
                swap(i, parent);
            heapifyUp(parent);
        }

        public void heapifyDown(int i) {
            int left = left(i), right = right(i);
            int smaller;
            if (right < count)
                smaller = (a[left] < a[right]) ? left : right;
            else if (left < count) smaller = left;
            else return;
            if (a[smaller] < a[i]) {
                swap(smaller, i);
                heapifyDown(smaller);
            }
        }

        public void buildHeap() {
            for (int i = count / 2; i >= 0; --i)
                heapifyDown(i);
        }

        public void add(long value) {
            if (a.length == count) expand();
            int index = count++;
            a[index] = value;
            heapifyUp(index);
        }

        public long removeTop() {
            if (count <= 0) return Integer.MIN_VALUE;
            long r = a[0];
            a[0] = a[--count];
            heapifyDown(0);
            return r;
        }

        public long top() {
            return a[0];
        }

        private void expand() {
            a = Arrays.copyOf(a, a.length * 2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int K = Integer.parseInt(tokenizer.nextToken());
        int N = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < K; ++i) {
            int temp = Integer.parseInt(tokenizer.nextToken());
            if (temp >= 2) treeSet.add(temp);
        }

        int[] primeNumbers = new int[treeSet.size()];
        int index = 0;
        for (int i : treeSet)
            primeNumbers[index++] = i;

        MinHeap minHeap = new MinHeap(N * 2);
        for (int i : primeNumbers)
            minHeap.add(i);

        int count = 0;
        long value = 0;
        while (true) {
            value = minHeap.removeTop();
            while (minHeap.top() == value)
                minHeap.removeTop();
            if (++count == N) break;
            for (long i : primeNumbers)
                minHeap.add(value * i);
        }
        System.out.println(value);
    }
}