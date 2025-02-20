package baekjoon.p01.p1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static long K;

    static long count(long n) {
        long sum = 0;
        for (long i = 1; i < n; ++i)
            sum += Math.min(N, n * n / i) - i;
        return sum * 2 + n;
    }

    static int 이진탐색() {
        int start = 1, end = N;
        while (start < end) {
            int middle = (start + end) / 2;
            long cnt = count(middle);
            if (cnt < K)
                start = middle + 1;
            else
                end = middle;
        }
        return start;
    }

    static List<Long> 영역값목록(long n) {
        List<Long> result = new ArrayList<>();
        long 제곱수 = n * n;
        long 이전제곱수 = (n - 1) * (n - 1);
        for (long i = 1; i < n; ++i) {
            long start = 이전제곱수 / i + 1, end = Math.min(N, 제곱수 / i);
            for (long j = start; j <= end; ++j) {
                result.add(j * i);
                result.add(j * i);
            }
        }
        result.add(제곱수);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        K = Long.parseLong(reader.readLine());
        long n = 이진탐색();

        if (K == count(n)) System.out.println(n * n);
        else {
            List<Long> 목록 = 영역값목록(n);
            Collections.sort(목록);
            int index = (int)(K - 1 - count(n - 1));
            System.out.println(목록.get(index));
        }
    }
}
