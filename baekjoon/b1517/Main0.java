package baekjoon.b1517;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main0 {
    static int[] A, temp;
    static int count = 0;


    static void bubbleSort() {
        for (int i = A.length - 1; i > 0; --i)
            for (int j = 0; j < i; ++j)
                if (A[j] > A[j + 1]) {
                    System.out.printf("%d %d\n", A[j], A[j + 1]);
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                    ++count;
                }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        A = new int[N];
        temp = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        bubbleSort();
        System.out.println(count);
    }
}