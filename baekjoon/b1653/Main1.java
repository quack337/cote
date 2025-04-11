package baekjoon.b1653;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main1 {
    static long value(int[] scale) {
        long result = 0;
        for (int i : scale)
            result = result * 10 + i;
        return result;
    }

    static final int[] L = {5, 4, 3, 2, 1, -1, -2, -3, -4, -5};

    static void DFS(int[] weights, int index, int sum, int[] scale, List<Long> results) {
        if (index > 0 && sum == 0) {   // 균형을 이루었으면
            results.add(value(scale)); // 평형정수 추가
            return;
        }
        if (index >= weights.length) return;
        DFS(weights, index+1, sum, scale, results); // index 번째 추를 사용 않하는 경우 재귀호출
        for (int i = 0; i < scale.length; ++i) {
            if (scale[i] != 0) continue; // 저울의 i 위치가 비어있지 않다.
            scale[i] = weights[index];   // 저울의 i 위치에 index 번째 추를 놓고,
            DFS(weights, index+1, sum + weights[index] * L[i], scale, results); // 재귀호출
            scale[i] = 0; // 저울의 i 위치에 index 번째 추를 놓기 취소
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] weights = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            weights[i] = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(reader.readLine());
        List<Long> results = new ArrayList<>();
        DFS(weights, 0, 0, new int[10], results);
        Collections.sort(results);
        System.out.println(results.get(Math.min(K, results.size()-1)));
    }
}