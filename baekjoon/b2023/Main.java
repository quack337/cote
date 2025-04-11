package baekjoon.b2023;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    static boolean isPrime(int value) {
        int limit = (int)Math.sqrt(value);
        for (int i = 2; i <= limit; ++i)
            if (value % i == 0)
                return false;
        return true;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws NumberFormatException, IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        ArrayList<Integer>[] A = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            A[i] = new ArrayList<Integer>();
        A[0].add(2); A[0].add(3);  A[0].add(5);  A[0].add(7);
        int[] B = { 1, 3, 7, 9 };
        for (int i = 1; i < N; ++i) {
            for (int a = 0; a < A[i - 1].size(); ++a)
                for (int b = 0; b < B.length; ++b) {
                    int value = A[i - 1].get(a) * 10 + B[b];
                    //System.out.printf("  %d %d %d\n", A[i - 1].get(a), B[b], value);
                    if (isPrime(value))
                        A[i].add(value);
                }
        }
        for (int i = 0; i < A[N-1].size(); ++i)
            writer.write(A[N-1].get(i) + "\n");
        writer.close();
    }
}