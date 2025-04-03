package ebay.e2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ex4 {

    @SuppressWarnings("unchecked")
    public static int[] solution(int N, int[][] relation) {
        List<Integer>[] 이웃 = new ArrayList[N]; // 이웃 노드 목록 ArrayList 배열
        for (int i = 0; i < 이웃.length; ++i)
            이웃[i] = new ArrayList<Integer>(); // 이웃 노드 목록 ArrayList
        for (int[] r : relation) {
            int a = r[0] - 1, b = r[1] - 1; // 인덱스가 0부터 시작할 수 있도록 1 빼기.
            이웃[a].add(b);                 // a의 이웃에 b 추가
            이웃[b].add(a);                 // b의 이웃에 a 추가
        }
        int[] a = new int[N];               // 결과 배열
        Set<Integer> set = new HashSet<>(); // 이웃 수를 세기 위한 집합
        for (int i = 0; i < a.length; ++i) {
            set.clear();
            set.addAll(이웃[i]);            // i 노드의 이웃 노드들 집합에 추가
            for (int j : 이웃[i])
                set.addAll(이웃[j]);        // i 노드의 이웃 노드의 이웃 노드를 집합에 추가
            a[i] = set.size() - 1;          // 자기 자신을 제외하기 위해 1 빼기
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] a1 = new int[][] { {1,2}, {4,2}, {3,1}, {4,5} };
        int[][] a2 = new int[][] { {1,2}, {4,2}, {3,1}, {4,5}, {6,7} };
        System.out.println(Arrays.toString(solution(5, a1)));
        System.out.println(Arrays.toString(solution(7, a2)));
    }
}
