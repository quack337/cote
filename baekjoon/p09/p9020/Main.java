package baekjoon.p09.p9020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<Integer> primeNumbers = getPrimeNumbers(10000);

    static List<Integer> getPrimeNumbers(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for(int i = 2; (i * i) <= n; ++i)
            if (prime[i]) {
                for(int j = i * 2; j <= n; j += i)
                    prime[j] = false;

            }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n; ++i)
            if (prime[i]) result.add(i);
        return result;
    }

    static void solution(int n) {
        int index = Collections.binarySearch(primeNumbers, n / 2);
        if (index < 0) index = -index - 1;
        for (int i = index; i >= 0; --i) {
            int a = primeNumbers.get(i);
            int b = n - a;
            if (Collections.binarySearch(primeNumbers, b) >= 0) {
                System.out.printf("%d %d\n", Math.min(a, b), Math.max(a, b));
                return;
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            int N = Integer.parseInt(reader.readLine());
            solution(N);
        }
    }
}