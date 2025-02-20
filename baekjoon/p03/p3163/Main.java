package baekjoon.p03.p3163;
// 시간초과
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, L, K;
    static int[] a, v;
    static double[] p;

    static int solution() {
        //System.out.println(Arrays.toString(v));
        //System.out.println(Arrays.toString(p));
        List<Integer> 떨어진개미 = new ArrayList<>();
        int start = 0, end = N-1;
        while (true) {
            // 최초 충돌까지 남은 시각 계산
            double 최초충돌 = L; // 최초 충돌까지 남은 시간
            int 충돌할개미 = -1; // 충돌할 개미 인덱스
            for (int i = start; i < end; ++i) { // 개미 각각에 대해서
                if (v[i] > 0 && v[i+1] < 0) {         // 서로를 향하여 오고있는가?
                    double t = (p[i+1] - p[i]) / 2.0; // 충돌 시각 계산
                    if (t < 최초충돌) {               // 최초 충돌인가?
                        최초충돌 = t;
                        충돌할개미 = i;
                    }
                }
            }
            // 최초 충돌 시각까지 모든 개미 이동
            for (int i = start; i <= end; ++i) // 모든 개미 각각에 대하여
                p[i] = p[i] + v[i] * 최초충돌; // 이동
            if (충돌할개미 >= 0) {     // 충돌한 개미 방향 전환
                v[충돌할개미] *= -1;
                v[충돌할개미+1] *= -1;
            }
            // 떨어진 개미 제거
            while (p[start] < 0 && p[end] > L && start < end) {
                if (-p[start] < p[end]-L) {
                    떨어진개미.add(a[end]);
                    떨어진개미.add(a[start]);
                } else {
                    떨어진개미.add(a[start]);
                    떨어진개미.add(a[end]);
                }
                ++start;
                --end;
            }
            while (p[start] < 0)
                떨어진개미.add(a[start++]);
            while (p[end] > L)
                떨어진개미.add(a[end--]);
            //System.out.println(Arrays.toString(p));
            if (떨어진개미.size() >= K) return 떨어진개미.get(K-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            L = Integer.parseInt(tokenizer.nextToken());
            K = Integer.parseInt(tokenizer.nextToken());
            p = new double[N];
            a = new int[N];
            v = new int[N];
            for (int i = 0; i < N; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                p[i] = Integer.parseInt(tokenizer.nextToken());
                a[i] = Integer.parseInt(tokenizer.nextToken());
                v[i] = a[i] > 0 ? +1 : -1;
            }
            System.out.println(solution());
        }

    }
}
