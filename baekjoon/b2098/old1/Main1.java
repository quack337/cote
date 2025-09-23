package baekjoon.b2098.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static final int INF = 1_000_000_000;
    static int N, 도시전체 = 0;
    static int[][] A;

    // 도시 번호가 1번부터 시작하기 때문에, 1을 빼고 bit 연산을 함.
    static boolean 이미방문하였나(int 방문한도시들, int 도시) {
        return ((방문한도시들 >> (도시-1)) & 1) == 1;
    }

    static int 방문(int 방문한도시들, int 도시) {
        return 방문한도시들 | (1 << (도시-1));
    }

    // 도시 번호는 1부터 시작한다.
    // 따라서 최초도시가 0 이면 아직 방문 시작 전 상태이다.
    static int 최소비용계산(int 현재도시, int 방문한도시들, int 최초도시) {
        if (방문한도시들 == 도시전체)
            return A[현재도시][최초도시]; // 최초 도시로 돌아가는 비용
        int 최소비용 = INF;
        for (int 다음도시 = 1; 다음도시 <= N; ++다음도시) {
            if (이미방문하였나(방문한도시들, 다음도시)) continue;
            int 이동비용 = A[현재도시][다음도시];
            int 비용 = 이동비용 + 최소비용계산(다음도시, 방문(방문한도시들, 다음도시),
                                                         최초도시 == 0 ? 다음도시 : 최초도시);
            // 최초도시 0인 상태에서 다음 방문하는 도시가 최초 방문 도시가 된다.

            if (비용 < 최소비용) 최소비용 = 비용;
        }
        return 최소비용;
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
        도시전체 = (int)Math.pow(2, N) - 1; // 모든 도시 비트를 1로 설정
        System.out.println(최소비용계산(0, 0, 0));
    }
}