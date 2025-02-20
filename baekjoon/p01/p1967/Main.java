package baekjoon.p01.p1967;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static class Result { // 각 노드들의 리턴 값 (최대깊이, 최대지름)
        long 깊이, 지름;
        public Result(long 깊이, long 지름) {
            this.깊이 = 깊이;
            this.지름 = 지름;
        }
    }

    static Map<Integer, Integer>[] 링크; // (key=이웃노드, value=거리)

    static Result 탐색(int 현재노드, int 부모노드) {
        if (링크[현재노드] == null) return new Result(0,0);
        long 최대지름 = 0, 최대깊이 = 0, 최대깊이2 = 0;
        for (int 이웃노드 : 링크[현재노드].keySet()) {
            if (이웃노드 == 부모노드) continue;
            Result 결과 = 탐색(이웃노드, 현재노드);
            최대지름 = Math.max(최대지름, 결과.지름); // 자식노드들이 리턴하는 최대지름의 최대값을 구함
            int 거리 = 링크[현재노드].get(이웃노드);  // 현재 노드와 자식 노드와의 거리
            결과.깊이 += 거리;               // 자식노드가 리턴한 최대깊이에, 자식노드까지의 거리를 더함
            if (최대깊이 < 결과.깊이) {
                최대깊이2 = 최대깊이;        // 2번째 최대깊이를 구한다.
                최대깊이 = 결과.깊이;        // 최대 깊이를 구한다.
            } else
                최대깊이2 = Math.max(최대깊이2, 결과.깊이); // 최대 깊이를 구한다.
        }
        return new Result(최대깊이, Math.max(최대지름, 최대깊이 + 최대깊이2));
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            링크 = new HashMap[N+1];
            for (int i = 0; i < N - 1; ++i) {
                int 노드1 = scanner.nextInt();
                int 노드2 = scanner.nextInt();
                int 거리 = scanner.nextInt();
                if (링크[노드1] == null) 링크[노드1] = new HashMap<>();
                링크[노드1].put(노드2, 거리);
            }
            Result 결과 = 탐색(1, 0);
            System.out.println(결과.지름);
        }
    }
}
