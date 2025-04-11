package baekjoon.b1547;
import java.util.Scanner;

public class Main {
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // 인덱스 0은 사용 안함. 컵 번호: 1, 2, 3
            int[] 위치 = {0, 1, 2, 3};
            int N = scanner.nextInt();
            for (int i = 0; i < N; ++i) {
                int 번호a = scanner.nextInt();
                int 번호b = scanner.nextInt();
                swap(위치, 번호a, 번호b);
            }
            // 위치 1에 있는 컵 번호 출력
            for (int 번호 = 1; 번호 <= 3; ++번호)
                if (위치[번호] == 1)
                    System.out.println(번호);
        }
    }
}