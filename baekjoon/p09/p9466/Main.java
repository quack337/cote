package baekjoon.p09.p9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] edge;
    static int[] count;

    static int solution() {
        int answer = 0;
        for (int i = 0; i < N; ++i) {
            int index = i;
            while (count[index] == 0 && edge[index] != -1) {
                ++answer;
                int index2 = edge[index];
                edge[index] = -1;
                index = index2;
                --count[index];
            }
        }
        return answer;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int test = 0; test < T; ++test) {
            N = Integer.parseInt(reader.readLine());
            edge = new int[N];
            count = new int[N];
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < N; ++i) {
                int index = Integer.parseInt(tokenizer.nextToken()) - 1;
                edge[i] = index;
                ++count[index];
            }
            System.out.println(solution());
        }
    }
}
