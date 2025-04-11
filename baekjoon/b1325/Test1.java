package baekjoon.b1325;
import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        Random random = new Random();
        int N = 20;
        int M = random.nextInt(15) + 10;
        System.out.printf("%d %d\n", N, M);
        for (int i = 0; i < M; ++i) {
            int a = random.nextInt(N) + 1;
            int b = random.nextInt(N) + 1;
            System.out.printf("%d %d\n", a, b);
        }
    }
}

/*
20 20
15 15
9 1
14 3
2 16
4 18
15 19
6 6
7 20
1 1
2 19
4 19
14 14
5 6
16 2
19 11
4 2
14 14
18 16
7 7
3 10
11
[2, 4, 2, 1, 1, 2, 1, 1, 1, 3, 8, 1, 1, 1, 1, 7, 1, 2, 7, 2]

11
[2, 4, 2, 1, 1, 2, 1, 1, 1, 3, 7, 1, 1, 1, 1, 4, 1, 2, 6, 2]

11 19
[2, 4, 2, 1, 1, 2, 1, 1, 1, 3, 7, 1, 1, 1, 1, 4, 1, 2, 7, 2]
*/