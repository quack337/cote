package baekjoon.p01.p1202;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Jewelry implements Comparable<Jewelry> {
        int 무게, 가격;

        @Override
        public int compareTo(Jewelry j) { // ORDER BY 무게, 가격
            int r;
            if ((r = 무게 - j.무게) != 0) return r;
            return 가격 - j.가격;
        }
    }

    static class MaxHeap {
        Jewelry[] a;
        int count = 0;

        public MaxHeap(int size) {
            a = new Jewelry[size];
        }

        private int parent(int index) {
            if (index == 0) return 0;
            return (index - 1) / 2;
        }

        private int left(int index) {
            return 2 * index + 1;
        }

        private int right(int index) {
            return 2 * index + 2;
        }

        private void swap(int i, int j) {
            Jewelry temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        private void heapifyUp(int i) {
            if (i == 0) return;
            int parent = parent(i);
            if (i > 0 && a[parent].가격 < a[i].가격)
                swap(i, parent);
            heapifyUp(parent);
        }

        public void heapifyDown(int i) {
            int left = left(i), right = right(i);
            int larger;
            if (right < count)
                larger = (a[left].가격 > a[right].가격) ? left : right;
            else if (left < count) larger = left;
            else return;
            if (a[larger].가격 > a[i].가격) {
                swap(larger, i);
                heapifyDown(larger);
            }
        }

        public void buildHeap() {
            for (int i = count / 2; i >= 0; --i)
                heapifyDown(i);
        }

        public void add(Jewelry 보석) {
            int index = count++;
            a[index] = 보석;
            heapifyUp(index);
        }

        public Jewelry removeTop() {
            if (count <= 0) return null;
            Jewelry r = a[0];
            a[0] = a[--count];
            heapifyDown(0);
            return r;
        }
    }

    static List<Jewelry> 보석목록;
    static List<Long> 가방목록;

    static long solution() {
        MaxHeap maxHeap = new MaxHeap(보석목록.size());
        int index = 0; long 합계 = 0;
        for (long 가방 : 가방목록) {
            while (index < 보석목록.size()) {
                Jewelry 보석 = 보석목록.get(index);
                if (보석.무게 <= 가방) {
                    maxHeap.add(보석);
                    ++index;
                } else break;
            }
            Jewelry 보석 = maxHeap.removeTop();
            if (보석 != null) 합계 += 보석.가격;
        }
        return 합계;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            보석목록 = new ArrayList<>();
            for (int i = 0; i < N; ++i) {
                Jewelry 보석 = new Jewelry();
                보석.무게 = scanner.nextInt();
                보석.가격 = scanner.nextInt();
                if (보석.가격 > 0) 보석목록.add(보석);
            }
            Collections.sort(보석목록);
            long 보석최소무게 = 보석목록.get(0).무게;
            가방목록 = new ArrayList<>();
            for (int i = 0; i < K; ++i) {
                long 가방 = scanner.nextLong();
                if (가방 >= 보석최소무게) 가방목록.add(가방);
            }
            Collections.sort(가방목록);
            System.out.println(solution());
        }
    }
}
