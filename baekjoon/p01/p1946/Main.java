package baekjoon.p01.p1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int test = 0; test < T; ++test) {
            int N = Integer.parseInt(reader.readLine());
            TreeSet<int[]> set = new TreeSet<>((a1, a2) -> a1[0] - a2[0]);
            for (int i = 0; i < N; ++i) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int[] a = new int[2];
                a[0] = Integer.parseInt(tokenizer.nextToken());
                a[1] = Integer.parseInt(tokenizer.nextToken());
                set.add(a);
            }
            int min = Integer.MAX_VALUE, count = 0;
            for (int[] a : set)
                if (a[1] < min) {
                    ++count;
                    min = a[1];
                }
            System.out.println(count);
        }
    }
}