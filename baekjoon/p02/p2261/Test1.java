package baekjoon.p02.p2261;

import java.util.Random;

public class Test1 {
  @SuppressWarnings("unused")
  public static void main(String[] args) {
        Random random = new Random();
        int N = 3000;
        System.out.println(N);
        for (int i = 0; i < N; ++i) {
            //int x = random.nextInt(20000) - 10000;
            //int y = random.nextInt(20000) - 10000;
            //int x = -i;
            //int y = -i;
            int x = (i % 2 == 0) ? -1 : 1;
            int y = -i;
            System.out.printf("%d %d\n", x, y);
        }
    }
}