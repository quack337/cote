package baekjoon.p03.p3584;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    static List<Integer> 루트로부터_경로(int[] 부모, int 노드) {
        var 경로 = new ArrayList<Integer>();
        while (true) {
            경로.add(노드);
            노드 = 부모[노드];
            if (노드 == 0) break;
        }
        Collections.reverse(경로);
        return 경로;
    }

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();
            for (int t = 0; t < T; ++t) {
                int N = scanner.nextInt();
                int[] 부모 = new int[N + 1];
                for (int n = 0; n < N-1; ++n) {
                    int parent = scanner.nextInt();
                    int child = scanner.nextInt();
                    부모[child] = parent;
                }
                int 노드1 = scanner.nextInt();
                int 노드2 = scanner.nextInt();
                List<Integer> 경로1 = 루트로부터_경로(부모, 노드1);
                List<Integer> 경로2 = 루트로부터_경로(부모, 노드2);
                int size = Math.min(경로1.size(), 경로2.size());
                int i = 0;
                while (i < size && 경로1.get(i) == 경로2.get(i))
                    ++i;
                if (i == 0) throw new NoSuchElementException("");
                System.out.println(경로1.get(i - 1));
            }
        }
    }
}
