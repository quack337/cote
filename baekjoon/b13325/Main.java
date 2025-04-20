package baekjoon.b13325;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] A;

    static int DFS(int i) {
        if (i >= A.length) return 0;
        int leftChildIndex = i * 2 + 1, rightChildIndex = i * 2 + 2;
        int leftWeight = DFS(leftChildIndex);
        int rightWeight = DFS(rightChildIndex);
        int diff = leftWeight - rightWeight;
        if (diff < 0) A[leftChildIndex] -= diff;
        else if (diff > 0) A[rightChildIndex] += diff;
        return Math.max(leftWeight, rightWeight) + A[i];
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(reader.readLine());
        int N = (int)Math.pow(2, K+1) - 1;
        A = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        DFS(0);
        int sum = 0;
        for (int i : A)
            sum += i;
        System.out.println(sum);
    }
}