package baekjoon.p02.p2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
      public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        reader.close();
        int from = 1, to = 1, answer = 0;
        while (from <= N) {
          int sum = (from + to) * (to - from + 1) / 2;
          if (sum == N) {
            ++answer;
            ++to; ++from;
          } else if (sum < N)
            ++to;
          else if (sum > N)
            ++from;
        }
        System.out.println(answer);
    }
}