package baekjoon.b11004;
import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        int N = 5000000;
        int[] a = new int[N];
        Random random = new Random();
        for (int i = 0; i < a.length; ++i)
            a[i] = i;
        for (int i = 0; i < a.length; ++i) {
            int j = random.nextInt(N);
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        System.out.printf("%d %d\n", N, 123456);
        for (int i = 0; i < a.length; ++i) {
            System.out.printf("%d ", a[i]);
        }
    }
}