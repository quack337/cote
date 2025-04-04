package baekjoon.b01.b1547;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] 컵 = {0, 1, 2, 3};
            int N = scanner.nextInt();
            for (int i = 0; i < N; ++i) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                swap(컵, a, b);

                System.out.println(Arrays.toString(컵));
            }
            System.out.println(컵[1]);
        }
    }
}