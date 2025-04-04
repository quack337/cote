package baekjoon.b11.p11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class MaxHeap {
        int[] a;
        int count = 0;

        public MaxHeap(int size) {
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
            if (a[parent] < a[i])
                swap(i, parent);
            heapifyUp(parent);
        }

        public void heapifyDown(int i) {
            int left = left(i), right = right(i);
            int larger;
            if (right < count)
                larger = (a[left] > a[right]) ? left : right;
            else if (left < count) larger = left;
            else return;
            if (a[larger] > a[i]) {
                swap(larger, i);
                heapifyDown(larger);
            }
        }

        public void buildHeap() {
            for (int i = count / 2; i >= 0; --i)
                heapifyDown(i);
        }

        public void add(int value) {
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
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        MaxHeap heap = new MaxHeap(N);
        for (int i = 0; i < N; ++i) {
            int a = Integer.parseInt(reader.readLine());
            if (a > 0) heap.add(a);
            else
                System.out.println(heap.count > 0 ? heap.removeTop() : 0);
        }
    }
}