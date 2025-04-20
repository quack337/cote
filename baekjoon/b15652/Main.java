package baekjoon.b15652;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static void DFS(BufferedWriter writer, int[] result, int index) throws IOException {
        if (index >= M) {
            for (int i : result) writer.write(i + " ");
            writer.write("\n");
            return;
        }
        int start = index == 0 ? 1 : result[index - 1];
        for (int i = start; i <= N; ++i) {
            result[index] = i;
            DFS(writer, result, index + 1);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        DFS(writer, new int[M], 0);
        writer.close();
    }
}