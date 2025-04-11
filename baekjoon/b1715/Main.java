package baekjoon.b1715;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        var minHeap = new PriorityQueue<Integer>();
        for (int i = 0; i < N; ++i)
            minHeap.add(Integer.parseInt(reader.readLine()));
        int answer = 0;
        while (minHeap.size() > 1) {
            int a = minHeap.remove();
            int b = minHeap.remove();
            int c = a + b;
            answer += c;
            minHeap.add(c);
        }
        System.out.println(answer);
    }
}