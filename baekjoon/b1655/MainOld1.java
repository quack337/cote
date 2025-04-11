package baekjoon.b1655;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MainOld1 {
    public static void main(String[] args) throws Exception {
        StringBuilder result = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
        int N = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; ++i) {
            int a = Integer.parseInt(reader.readLine());

            // 두 힙 중 어느쪽에 add 할까
            if (minHeap.size() + maxHeap.size() == 0)
                maxHeap.add(a);
            else {
                if (maxHeap.peek() > a) maxHeap.add(a);
                else minHeap.add(a);
            }

            // 두 힙 크기 맞추기
            while (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
                if (maxHeap.size() > minHeap.size()) minHeap.add(maxHeap.remove());
                else maxHeap.add(minHeap.remove());
            }

            // 중간값 출력
            result.append(minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek()).append('\n');
        }
        System.out.println(result);
    }
}