package sw.p8383;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long value(int[] a) {
        int result = 0;
        for (int i : a)
            result = result * 10 + i;
        return result;
    }

    static long sol(int N, int x, int y) {
        int length = String.valueOf(N).length();
        int[] a = new int[length];
        for (int i = 0; i < length; ++i) {
            a[i] = y;
            if (value(a) <= N) continue;
            a[i] = x;
            if (value(a) > N) return -1;
        }
        long result = value(a);
        return result == 0 ? -1 : result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 1; t <= T; ++t) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            System.out.println("#" + t + " " + sol(N, x, y));
        }
    }

}
