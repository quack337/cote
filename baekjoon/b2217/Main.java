package baekjoon.b2217;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(reader.readLine());
        Arrays.sort(A);
        int max = 0;
        for (int i = 0; i < N; ++i)
            max = Math.max(max, A[i] * (N - i));
        System.out.println(max);
    }
}