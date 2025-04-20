package baekjoon.b11650;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[][] A = new int[N][2];
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            A[i][0] = Integer.parseInt(tokenizer.nextToken());
            A[i][1] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(A, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        var builder = new StringBuilder();
        for (int[] a : A)
            builder.append(a[0] + " " + a[1] + "\n");
        System.out.println(builder.toString());
    }

}