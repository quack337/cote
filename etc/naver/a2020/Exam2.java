package naver.a2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam2 {

    static List<int[]>[] 이웃정점목록;
    static List<Integer> 선택된간선;

    static int DFS(int 현재정점, int 부모정점) {
        int 서브트리의크기 = 1;
        for (int[] 이웃정점 : 이웃정점목록[현재정점])
            if (이웃정점[0] != 부모정점) {
                int 크기 = DFS(이웃정점[0], 현재정점);
                if (크기 % (이웃정점목록.length/3) == 0) 선택된간선.add(이웃정점[1]);
                서브트리의크기 += 크기;
            }
        return 서브트리의크기;
    }

    @SuppressWarnings("unchecked")
    static int[] solution(int n, int[][] edges) {
        선택된간선 = new ArrayList<>();
        이웃정점목록 = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            이웃정점목록[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; ++i) {
            int 정점1 = edges[i][0], 정점2 = edges[i][1];
            이웃정점목록[정점1].add(new int[] { 정점2, i });
            이웃정점목록[정점2].add(new int[] { 정점1, i });
        }
        DFS(0, -1);
        return 선택된간선.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[][] a1 =  {{0,2},{2,1},{2,4},{3,5},{5,4},{5,7},{7,6},{6,8}};
        System.out.println(Arrays.toString(solution(a1.length + 1, a1)));


        int[][] a2 =  {{0,1},{2,0}};
        System.out.println(Arrays.toString(solution(a2.length + 1, a2)));
    }
}