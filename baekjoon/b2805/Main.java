package baekjoon.b2805;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long 절단(long[] trees, long height) {
        long sum = 0;
        for (long tree : trees)
            if (tree > height) sum += tree - height;
        return sum;
    }

    static long binarySearch(long[] trees, long M) {
        long start = 0, end = 1000000000, answer = 0;
        while (start <= end) {
            long middle = (start + end) / 2;
            long value = 절단(trees, middle);
            if (value >= M) {
                start = middle + 1;
                answer = middle;
            }
            else end = middle - 1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        long M = Integer.parseInt(tokenizer.nextToken());
        long[] trees = new long[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            trees[i] = Long.parseLong(tokenizer.nextToken());
        System.out.println(binarySearch(trees, M));
    }
}