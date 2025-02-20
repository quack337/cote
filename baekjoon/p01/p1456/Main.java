package baekjoon.p01.p1456;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean[] prim;

    static void 소수찾기(int n) {
        int limit = (int)Math.sqrt(n);
        for (int i = 2; i <= limit; ++i) {
            if (prim[i] == false) continue;
            for (int j = i * 2; j <= n; j += i)
                if (prim[j])
                    prim[j] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long a = Long.parseLong(tokenizer.nextToken());
        long b = Long.parseLong(tokenizer.nextToken());

        int n = (int)Math.sqrt(b);
        prim = new boolean[n + 1];
        Arrays.fill(prim, true);
        prim[0] = prim[1] = false;
        소수찾기(n);

        int answer = 0;
        for (int i = 2; i <= n; ++i) {
            if (prim[i] == false) continue;
            int start = (int)(Math.log(a) / Math.log(i));
            while (Math.pow(i, start) < a || start <= 1)
                ++start;
            int end = (int)(Math.log(b) / Math.log(i));
            answer += Math.max(0, (end - start + 1));
        }
        System.out.println(answer);
    }
}
