package baekjoon.b2110;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int 공유기설치(int[] A, int 간격) {
        int previous = A[0], count = 1;
        for (int i = 1; i < A.length; ++i) {
            if (A[i] - previous >= 간격) {
                previous = A[i];
                ++count;
            }
        }
        return count;
    }

    static int 파라매트릭서치(int[] A, int start, int end, int C) {
        int answer = 0;
        while (start <= end) {
            int middle = (start + end) / 2;
            int count = 공유기설치(A, middle);
            if (count >= C) {
                start = middle + 1;
                answer = middle;
            } else
                end = middle - 1;
        }
        return answer;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());
        int[] A = new int[N];
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(reader.readLine());
        Arrays.sort(A);
        System.out.println(파라매트릭서치(A, 1, A[N-1] - A[0], C));
    }
}