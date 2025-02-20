package baekjoon.p15.p15651;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main2 {
    static int N, M;

    static void DFS(BufferedWriter writer, ArrayDeque<Integer> result) throws IOException {
        if (result.size() == M) {
            for (int i : result) writer.write(i + " ");
            writer.write("\n");
            return;
        }
        for (int i = 1; i <= N; ++i) {
            result.add(i);
            DFS(writer, result);
            result.removeLast();
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        DFS(writer, new ArrayDeque<Integer>());
        writer.close();
    }
}
