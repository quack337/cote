package baekjoon.b4673;
import java.util.Arrays;

public class Main {
    static int d(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        final int N = 10000;
        boolean[] selfNumbers = new boolean[N+1];
        Arrays.fill(selfNumbers, true);
        for (int i = 1; i <= N; ++i) {
            int t = d(i);
            if (t <= N)
                selfNumbers[t] = false;
        }
        for (int i = 1; i <= N; ++i)
            if (selfNumbers[i])
                System.out.println(i);
    }
}