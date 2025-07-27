package baekjoon.b1904.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    static final int MOD = 15746;
    static int N;

    static int 경우의수(int length) {
        if (length == 0) return 1;
        int sum = 0;
        if (length >= 2) sum += 경우의수(length - 2);
        sum += 경우의수(length - 1);
        return sum;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        System.out.println(경우의수(N));
    }
}