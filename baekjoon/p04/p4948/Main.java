package baekjoon.p04.p4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<Integer> primeNumbers = getPrimeNumbers(123456 * 2);

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

    static int solution(int n) {
        int index1 = Collections.binarySearch(primeNumbers, n);
        if (index1 < 0) index1 = -index1 - 1; else ++index1;
        int index2 = Collections.binarySearch(primeNumbers, 2 * n);
        if (index2 < 0) index2 = -index2 - 1; else ++index2;
        return index2 - index1;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int N = Integer.parseInt(reader.readLine());
            if (N == 0) break;
            System.out.println(solution(N));
        }
    }
}