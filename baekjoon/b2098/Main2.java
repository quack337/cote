package baekjoon.b2098;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static final int INF = 1_000_000_000;
    static int N, 도시전체 = 0;
    static int[][] A;
    static Integer[][][] DP;

    static boolean 이미방문하였나(int 방문한도시들, int 도시) {
        return ((방문한도시들 >> (도시-1)) & 1) == 1;
    }

    static int 방문(int 방문한도시들, int 도시) {
        return 방문한도시들 | (1 << (도시-1));
    }

    static int 최소비용계산(int 현재도시, int 방문한도시들, int 최초도시) {
        if (방문한도시들 == 도시전체)
            return DP[현재도시][방문한도시들][최초도시] = A[현재도시][최초도시];
        if (DP[현재도시][방문한도시들][최초도시] != null)
            return DP[현재도시][방문한도시들][최초도시];
        int 최소비용 = INF;
        for (int 다음도시 = 1; 다음도시 <= N; ++다음도시) {
            if (이미방문하였나(방문한도시들, 다음도시)) continue;
            int 이동비용 = A[현재도시][다음도시];
            int 비용 = 이동비용 + 최소비용계산(다음도시, 방문(방문한도시들, 다음도시),
                                                         최초도시 == 0 ? 다음도시 : 최초도시);
            if (비용 < 최소비용) 최소비용 = 비용;
        }
        return DP[현재도시][방문한도시들][최초도시] = 최소비용;
    }

    static void 역추적() {
        int 현재도시 = 0, 방문한도시들 = 0, 최초도시 = 0;
        while (방문한도시들 != 도시전체) {
            for (int 다음도시 = 1; 다음도시 <= N; ++다음도시) {
                if (이미방문하였나(방문한도시들, 다음도시)) continue;
                int 이동비용 = A[현재도시][다음도시];
                int 비용 = 이동비용 + DP[다음도시][방문(방문한도시들, 다음도시)][최초도시 == 0 ? 다음도시 : 최초도시];
                if (비용 == DP[현재도시][방문한도시들][최초도시]) {
                    System.out.println(다음도시);
                    현재도시 = 다음도시;
                    방문한도시들 = 방문(방문한도시들, 다음도시);
                    최초도시 = 최초도시 == 0 ? 다음도시 : 최초도시;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        A = new int[N + 1][N + 1];
        for (int r = 1; r <= N; ++r) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 1; c <= N; ++c) {
                A[r][c] = Integer.parseInt(tokenizer.nextToken());
                if (A[r][c] == 0 && r != c)
                    A[r][c] = INF;
            }
        }
        도시전체 = (int)Math.pow(2, N) - 1;
        DP = new Integer[N+1][(int)Math.pow(2, N)][N + 1];
        System.out.println(최소비용계산(0, 0, 0));
    }
}