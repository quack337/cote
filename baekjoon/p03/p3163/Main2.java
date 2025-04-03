package baekjoon.p03.p3163;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
    static int N, L, K;
    static int[] p, a, v;

    static int solution() {
        //System.out.println(Arrays.toString(p));
        List<Integer> 떨어진개미 = new ArrayList<>();
        int start = 0, end = N-1;
        while (true) {
            for (int i = start; i <= end; ++i) { // 모든 개미 각각에 대해서
                p[i] = p[i] + v[i];       // 1칸 이동
                if (v[i] < 0) {           // 왼쪽으로 이동중
                    if (p[i] == -1) {     // 떨어졌는가?
                        떨어진개미.add(a[i]);
                        ++start;
                    }
                    else if (i > 0 && p[i-1] == p[i]) {  // 충돌했는가?
                        v[i-1] *= -1;                    // 방향 전환
                        v[i] *= -1;
                    }
                } else {                  // 오른쪽으로 이동중
                    if (p[i] == L+1) {     // 떨어졌는가?
                        떨어진개미.add(a[i]);
                        --end;
                    }
                    else if (i < N-1 && p[i] == p[i+1] && v[i] != v[i+1]) { // 충돌했는가?
                        --p[i];
                        v[i] *= -1;                         // 방향 전환
                        v[i+1] *= -1;
                        ++i;
                    }
                }
            }
            //System.out.println(Arrays.toString(p));
            if (떨어진개미.size() >= K) {
                if (떨어진개미.size() == K) return 떨어진개미.get(K-1);
                return Math.min(떨어진개미.get(K-1), 떨어진개미.get(K));
            }
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
            p = new int[N];
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