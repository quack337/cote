package baekjoon.b11726;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    static int 경우의수(int n) {
        if (n == 0) return 1;
        int count = 0;
        if (n >= 2) count += 경우의수(n - 2); // 2x1 타일 선택
        count += 경우의수(n - 1);             // 1x2 타일 선택
        return count;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        System.out.println(경우의수(N));
    }
}