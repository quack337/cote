package programmers.e81304;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Test2 {

    static class Solution {
static class Location{
    int no, distance;
    Map<Integer, Boolean> 함정상태;

    Location(int index, int distance, Map<Integer, Boolean> 함정상태) {
        this.no = index;
        this.distance = distance;
        this.함정상태 = 함정상태;
    }
}

        static void addLink(Map<Integer, List<int[]>> map, int no, int[] r) {
            List<int[]> list = map.get(no);
            if (list == null)
                map.put(no, list = new ArrayList<>());
            list.add(r);
        }


        public int solution(int n, int start, int end, int[][] roads, int[] traps) {
            Map<Integer, Boolean> 함정상태 = new HashMap<>();
            for (int t : traps) 함정상태.put(t, false);
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] r : roads) {
                addLink(graph, r[0], r);
                addLink(graph, r[1], r);
            }
            int[] 방문횟수 = new int[n + 1];
            PriorityQueue<Location> queue = new PriorityQueue<>((a, b) -> a.distance - b.distance);
            queue.add(new Location(start, 0, 함정상태));
            while (queue.size() > 0) {
                Location p = queue.remove();
                if (p.no == end) return p.distance;
                if (방문횟수[p.no] > 2) continue;
                방문횟수[p.no]++;

                함정상태 = p.함정상태;
                if (함정상태.get(p.no) != null) {
                    Map<Integer, Boolean> 새상태 = new HashMap<>();
                    새상태.putAll(함정상태);
                    함정상태 = 새상태;
                    함정상태.put(p.no, !함정상태.get(p.no));
                }
                for (int[] r : graph.get(p.no)) {
                    boolean 상태1 = 함정상태.get(r[0]) == null ? false : 함정상태.get(r[0]);
                    boolean 상태2 = 함정상태.get(r[1]) == null ? false : 함정상태.get(r[1]);
                    int from = 0, to = 1;
                    if (상태1 != 상태2) {
                        from = 1; to = 0;
                    }
                    if (r[from] == p.no)
                        queue.add(new Location(r[to], p.distance + r[2], 함정상태));
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(3,1,3, new int[][] {{1,2,2},{3,2,3}}, new int[] {2}));
        System.out.println(sol.solution(4,1,4, new int[][] {{1,2,1},{3,2,1},{2,4,1}}, new int[] {2,3}));
    }
}