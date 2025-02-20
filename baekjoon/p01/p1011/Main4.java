package baekjoon.p01.p1011;

public class Main4 {

    public static void main(String[] args) {
        int 거리 = 1;
        int 점프수 = 1;
        int 반복수 = 1;

        while (점프수 <= 13) {
            for (int j = 0; j < 2; ++j) {
                for (int i = 0; i < 반복수; ++i)
                    System.out.printf("거리=%d 점프수=%d\n", 거리++, 점프수);
                ++점프수;
            }
            ++반복수;
        }
    }
}
