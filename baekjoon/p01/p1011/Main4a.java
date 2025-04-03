package baekjoon.p01.p1011;

public class Main4a {

    static int 점프수(int X) {
        int 거리 = 1;
        int 점프수 = 1;
        int 반복수 = 1;
        while (true) {
            for (int j = 0; j < 2; ++j) {
                for (int i = 0; i < 반복수; ++i) {
                    System.out.printf("거리=%d 점프수=%d\n", 거리, 점프수);
                    if (거리 == X) return 점프수;
                    ++거리;
                }
                ++점프수;
            }
            ++반복수;
        }
    }

    public static void main(String[] args) {
        System.out.println(점프수(30));

    }
}