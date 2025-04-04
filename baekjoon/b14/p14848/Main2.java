package baekjoon.b14.p14848;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        BitSet A = new BitSet(N + 1);
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < K; ++i) {
            int a = Integer.parseInt(tokenizer.nextToken());
            for (int j = 1; a * j <= N; ++j)
                A.set(a * j, true);
        }
        int count = 0;
        for (int i = 1; i <= N; ++i)
            if (!A.get(i)) ++count;
        System.out.println(count);
    }
}