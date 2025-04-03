package baekjoon.p01.p1929;

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

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int M = Integer.parseInt(tokenizer.nextToken());
        int N = Integer.parseInt(tokenizer.nextToken());
        List<Integer> primeNumbers = getPrimeNumbers(N);
        int index = Collections.binarySearch(primeNumbers, M);
        if (index < 0) index = -index - 1;
        for (int i = index; i < primeNumbers.size(); ++i)
            System.out.println(primeNumbers.get(i));
    }
}