package baekjoon.b11066;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int[] 크기;

    static class Result {
        int 크기, 비용;
        public Result(int 크기, int 비용) {
            this.크기 = 크기;
            this.비용 = 비용;
        }
    }

    static Result 최소비용(int start, int end) {
        if (start == end) return new Result(크기[start], 0);
        Result 최소 = null;
        for (int middle = start; middle < end; ++middle) {
            Result r1 = 최소비용(start, middle);
            Result r2 = 최소비용(middle + 1, end);
            Result r = new Result(r1.크기 + r2.크기, r1.비용 + r2.비용 + r1.크기 + r2.크기);
            if (최소 == null || r.비용 < 최소.비용) 최소 = r;
        }
        return 최소;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            int N = Integer.parseInt(reader.readLine());
            크기 = new int[N];
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < N; ++i)
                크기[i] = Integer.parseInt(tokenizer.nextToken());
            System.out.println(최소비용(0, N - 1).비용);
        }
    }
}