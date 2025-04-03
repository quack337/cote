package baekjoon.p11.p11401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static class Key {
        int n, r;

        public Key(int n, int r) {
            this.n = n;
            this.r = r;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, r);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Key)) return false;
            Key k = (Key)obj;
            return n == k.n && r == k.r;
        }
    }

    static final int MOD = 1000000007;
    static HashMap<Key, Integer> DP = new HashMap<>();

    static int nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        if (r == 0 || r == n) return 1;
        Key key = new Key(r, n);
        if (DP.get(key) != null) return DP.get(key);
        int value = (nCr(n-1, r-1) + nCr(n-1, r)) % MOD;
        DP.put(key, value);
        return value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        System.out.println(nCr(N, K));
    }
}