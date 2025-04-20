package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int[] A = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());

        var builder = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            builder.append(A[i]);
            builder.append(' ');
        }
        System.out.println(builder.toString());
        /*
        var writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; ++i) {
            writer.write(String.valueOf(A[i]));
            writer.write(' ');
        }
        writer.flush();
        */
    }
}