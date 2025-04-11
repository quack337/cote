package etcc.naver.b2020;
import java.util.ArrayList;
import java.util.List;

public class Exam3 {

    static List<Integer>[] 자식목록;

    static int 감염(List<Integer> 감염대상노드목록, int 자를노드, int 감염된노드수) {
        List<Integer> 자식노드목록 = new ArrayList<>();
        for (int 노드 : 감염대상노드목록) {
            if (노드 == 자를노드) continue;
            ++감염된노드수;
            자식노드목록.addAll(자식목록[노드]);
        }
        if (자식노드목록.size() == 0) return 감염된노드수;
        int 최소감염수 = Integer.MAX_VALUE;
        for (int 자식노드 : 자식노드목록) {
            int 감염수 = 감염(자식노드목록, 자식노드, 감염된노드수);
            if (감염수 < 최소감염수) 최소감염수 = 감염수;
        }
        return 최소감염수;
    }

    @SuppressWarnings("unchecked")
    static int solution(int n, int[][] edges) {
        자식목록 = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            자식목록[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; ++i) {
            int 노드1 = edges[i][0], 노드2 = edges[i][1];
            자식목록[노드1].add(노드2);
        }
        List<Integer> 감염대상노드목록 = new ArrayList<>();
        감염대상노드목록.add(0);
        return 감염(감염대상노드목록, -1, 0);
    }

    public static void main(String[] args) {
        int[][] a1 =  {{0, 1}, {0, 2}, {0, 3}, {1, 4}, {1, 5}, {2, 6}, {3, 7}, {3, 8}, {3, 9},
                {4, 10}, {4, 11}, {5, 12}, {5, 13}, {6, 14}, {6, 15}, {6, 16}, {8, 17}, {8, 18}};
        System.out.println(solution(a1.length + 1, a1));


        int[][] a2 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {2, 7}, {3, 8}, {3, 9},
                {3, 10}, {4, 11}, {4, 12}, {4, 13}};
        System.out.println(solution(a2.length + 1, a2));

        int[][] a3 = {{0, 1}, {0, 2}, {1, 3}, {2, 4}, {2, 5}, {2, 6}, {3, 7}, {3, 8}, {3, 9}};
        System.out.println(solution(a3.length + 1, a3));
    }
}