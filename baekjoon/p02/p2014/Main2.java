package baekjoon.p02.p2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main2 {
    static class MinHeap {
        int[] a;
        int count = 0;

        public MinHeap(int size) {
            a = new int[size];
        }

        private int parent(int index) {
            if (index == 0) return 0;
            return (index - 1) / 2;
        }

        private int left(int index) { return 2 * index + 1; }
        private int right(int index) { return 2 * index + 2; }

        private void swap(int i, int j) {
            int temp = a[i];
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

        public void add(int value) {
            if (a.length == count) expand();
            int index = count++;
            a[index] = value;
            heapifyUp(index);
        }

        public int removeTop() {
            if (count <= 0) return Integer.MIN_VALUE;
            int r = a[0];
            a[0] = a[--count];
            heapifyDown(0);
            return r;
        }

        public int top() {
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
        MinHeap minHeap = new MinHeap(N * 2);
        int[] primNumbers = new int[K];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < K; ++i) {
            primNumbers[i] = Integer.parseInt(tokenizer.nextToken());
            minHeap.add(primNumbers[i]);
        }
        int count = 0, value = 0;
        while (true) {
            value = minHeap.removeTop();
            while (minHeap.top() == value)
                minHeap.removeTop();
            if (++count == N) break;
            for (int i : primNumbers) {
                minHeap.add(value * i);
            }
        }
        System.out.println(value);
    }
}
