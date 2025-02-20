package baekjoon.p01.p1655;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main2 {
    public static void main(String[] args) throws Exception {
        StringBuilder result = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer>  A = new PriorityQueue<>();
        PriorityQueue<Integer> B = new PriorityQueue<>((i1, i2) -> i2 - i1);
        int N = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; ++i) {
            int x = Integer.parseInt(reader.readLine());

            // 두 힙 중 어느쪽에 add 할까
            if (A.size() == 0 || x <= A.peek()) A.add(x);
            else B.add(x);

            // A 가 너무 크다면, A 그룹의 최대값들을 B 그룹으로 이동
            while (A.size() > B.size() + 1) {
              int value = A.remove();
               B.add(value);
            }

            // B 가 너무 크다면, B 그룹의 최소값들을 A 그룹으로 이동
            while (B.size() > A.size()) {
               int value = B.remove();
               A.add(value);
            }

            // 중간값 출력
            result.append(A.peek()).append('\n');
        }
        System.out.println(result);
    }
}
