package baekjoon.b01.b1914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static BigInteger[] hanoi100() {
        final BigInteger one = BigInteger.valueOf(1), two = BigInteger.valueOf(2);
        BigInteger[] DP = new BigInteger[101];
        DP[1] = BigInteger.valueOf(1);
        for (int i = 2; i <= 100; ++i)
            DP[i] = DP[i - 1].multiply(two).add(one);
        return DP;
    }

    static int hanoi20(StringBuilder builder, int count, int from, int to, int temp) {
        if (count == 1) {
            builder.append(from).append(' ').append(to).append('\n');
            return 1;
        }
        return hanoi20(builder, count - 1, from, temp, to) +
               hanoi20(builder, 1, from, to, temp) +
               hanoi20(builder, count - 1, temp, to, from);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        if (N <= 20) {
            StringBuilder builder = new StringBuilder();
            int count = hanoi20(builder, N, 1, 3, 2);
            builder.insert(0, count + "\n");
            System.out.println(builder);
        } else {
            BigInteger[] DP = hanoi100();
            System.out.println(DP[N]);
        }
    }
}