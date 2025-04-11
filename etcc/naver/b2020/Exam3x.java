package etcc.naver.b2020;
import java.util.ArrayList;
import java.util.List;

public class Exam3x {

    static List<Integer>[] 자식목록;

    static int 최소감염수(int 노드) {
        int 합계 = 0, 최대 = 0;
        for (int 자식 : 자식목록[노드]) {
            int 수 = 최소감염수(자식);
            if (수 > 최대) 최대 = 수;
            합계 += 수;
        }
        System.out.printf("%d %d %d %d\n", 노드, 합계, 최대, 합계 - 최대 + 1);
        return 합계 - 최대 + 1;
    }

    @SuppressWarnings("unchecked")
    static int solution(int n, int[][] edges) {
        자식목록 = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            자식목록[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; ++i) {
            int 정점1 = edges[i][0], 정점2 = edges[i][1];
            자식목록[정점1].add(정점2);
        }
        return 최소감염수(0);
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        int[][] a1 =  {{0, 1}, {0, 2}, {0, 3}, {1, 4}, {1, 5}, {2, 6}, {3, 7}, {3, 8}, {3, 9},
                {4, 10}, {4, 11}, {5, 12}, {5, 13}, {6, 14}, {6, 15}, {6, 16}, {8, 17}, {8, 18}};
        System.out.println(solution(a1.length + 1, a1));


        int[][] a2 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {2, 7}, {3, 8}, {3, 9},
                {3, 10}, {4, 11}, {4, 12}, {4, 13}};
        //System.out.println(solution(a2.length + 1, a2));

        int[][] a3 = {{0, 1}, {0, 2}, {1, 3}, {2, 4}, {2, 5}, {2, 6}, {3, 7}, {3, 8}, {3, 9}};
        //System.out.println(solution(a3.length + 1, a3));
    }
}