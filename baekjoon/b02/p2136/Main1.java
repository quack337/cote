package baekjoon.b02.p2136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {
    static class Ant {
        int no, dir; long position;

        public Ant(int no, long position) {
            this.no = no;
            this.dir = position < 0 ? 0 : 1;
            this.position = Math.abs(position);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int L = Integer.parseInt(tokenizer.nextToken());
        Ant[] A1 = new Ant[N];
        for (int i = 0; i < N; ++i) {
            long position = Long.parseLong(reader.readLine());
            A1[i] = new Ant(i + 1, position);
        }
        Arrays.sort(A1, (a1, a2) -> {
            return (int)(a1.position - a2.position);
        });
        Ant[] A2 = Arrays.copyOf(A1, A1.length);
        Arrays.sort(A2, (a1, a2) -> {
            int r = a1.dir - a2.dir;
            if (r != 0) return r;
            return (int)(a1.position - a2.position);
        });
        long max_t = 0; int max_i = 0;
        for (int i = 0; i < N; ++i) {
            long t = A2[i].dir == 0 ? A2[i].position : L - A2[i].position;
            if (t > max_t) { max_t = t; max_i = i; }
        }
        System.out.printf("%d %d\n", A1[max_i].no, max_t);
    }
}