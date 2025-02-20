package baekjoon.p01.p1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

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

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        List<Integer> primeNumbers = getPrimeNumbers(1000);
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int count = 0;
        for (int i = 0; i < N; ++i) {
            int x = Integer.parseInt(tokenizer.nextToken());
            if (Collections.binarySearch(primeNumbers, x) >= 0)
                ++count;
        }
        System.out.println(count);
    }
}
