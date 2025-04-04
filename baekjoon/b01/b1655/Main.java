package baekjoon.b01.b1655;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        var result = new StringBuilder();
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var A = new PriorityQueue<Integer>((i1, i2) -> i2 - i1);
        var B = new PriorityQueue<Integer>();
        int N = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; ++i) {
            int x = Integer.parseInt(reader.readLine());
            if (A.size() == 0 || x <= A.peek()) A.add(x);
            else B.add(x);

            while (A.size() > B.size() + 1)
              B.add(A.remove());

            while (B.size() > A.size())
               A.add(B.remove());

            result.append(A.peek()).append('\n');
        }
        System.out.println(result);
    }
}