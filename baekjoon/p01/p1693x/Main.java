package baekjoon.p01.p1693x;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer>[] 링크;
    static int 합계 = 0;

    static void 탐색(int 현재노드, int 부모노드, int 현재노드색) {
        System.out.printf("%d %d\n", 현재노드, 현재노드색);
        합계 += 현재노드색;
        int 색 = 0;
        for (int 이웃노드 : 링크[현재노드])
            if (이웃노드 != 부모노드) {
                if (++색 == 현재노드색) ++색;
                탐색(이웃노드, 현재노드, 색);
            }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            링크 = new List[N+1];
            for (int i = 0; i < N - 1; ++i) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (링크[a] == null) 링크[a] = new ArrayList<>();
                if (링크[b] == null) 링크[b] = new ArrayList<>();
                링크[a].add(b);
                링크[b].add(a);
            }
            탐색(1, 0, 1);
            System.out.println(합계);
        }
    }
}
