package baekjoon.b11.p11653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    static List<Integer> getPrimeFactors(int n) {
        List<Integer> primeNumbers = getPrimeNumbers(n);
        List<Integer> result = new ArrayList<Integer>();
        for (int p : primeNumbers) {
            while (n % p == 0) {
                result.add(p);
                n /= p;
            }
            if (n == 1) break;
        }
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        for (int f : getPrimeFactors(N))
            System.out.println(f);
    }
}