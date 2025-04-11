package baekjoon.b2231;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int 분해합(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int 자릿수 = s.length();
        int N = Integer.parseInt(s);
        int 최소값 = Math.max(1, N - 자릿수 * 9);
        int answer = 0;
        for (int i = 최소값; i < N; ++i)
            if (분해합(i) == N) {
                answer = i;
                break;
            }
        System.out.println(answer);
    }
}