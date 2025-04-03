package baekjoon.p11.p11659;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = reader.readLine();
        var tokennizer = new StringTokenizer(s);
        int N = Integer.parseInt(tokennizer.nextToken());
        int M = Integer.parseInt(tokennizer.nextToken());
        int[] A = new int[N + 1];
        s = reader.readLine();
        tokennizer = new StringTokenizer(s);
        for (int i = 1; i <= N; ++i)
            A[i] = Integer.parseInt(tokennizer.nextToken());
        int[] S = new int[N + 1];
        for (int i = 1; i <= N; ++i)
          S[i] = S[i - 1] + A[i];
        for (int i = 0; i < M; ++i) {
          s = reader.readLine();
          tokennizer = new StringTokenizer(s);
          int from = Integer.parseInt(tokennizer.nextToken());
          int to = Integer.parseInt(tokennizer.nextToken());
          int answer = S[to] - S[from - 1];
          writer.write(answer + "\n");
        }
        reader.close();
        writer.close();
    }
}