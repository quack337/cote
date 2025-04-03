package baekjoon.p01.p1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        var maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        var minHeap = new PriorityQueue<Integer>();
        boolean zero = false;
        for (int i = 0; i < N; ++i) {
            int value = Integer.parseInt(reader.readLine());
            if (value > 0) maxHeap.add(value);
            else if (value < 0) minHeap.add(value);
            else zero = true;
        }
        int answer = 0;
        while (maxHeap.size() >= 2) {
            int a = maxHeap.remove();
            int b = maxHeap.remove();
            answer += Math.max(a * b, a + b);
        }
        if (maxHeap.size() == 1)
            answer += maxHeap.remove();
        while (minHeap.size() >= 2) {
            int a = minHeap.remove();
            int b = minHeap.remove();
            answer += a * b;
        }
        if (minHeap.size() == 1 && zero == false)
            answer += minHeap.remove();
        System.out.println(answer);
    }
}