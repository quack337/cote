package baekjoon.p11.p11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        var heap = new PriorityQueue<Integer>((a, b) -> {
            int r = Math.abs(a) - Math.abs(b);
            if (r != 0) return r;
            return a - b;
        });
        for (int i = 0; i < N; ++i) {
            int a = Integer.parseInt(reader.readLine());
            if (a != 0) heap.add(a);
            else
                System.out.println(heap.size() > 0 ? heap.remove() : 0);
        }
    }
}
