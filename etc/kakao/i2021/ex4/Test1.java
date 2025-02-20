package net.skhu.kakao.i2021.ex4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Test1 {

    static class Solution {
        static class Location{
            int no, distance;

            Location(int no, int distance) {
                this.no = no;
                this.distance = distance;
            }
        }

        static void addLink(Map<Integer, List<int[]>> map, int no, int[] r) {
            List<int[]> links = map.get(no);
            if (links == null)
                map.put(no, links = new ArrayList<>());
            links.add(r);
        }

        public int solution(int n, int start, int end, int[][] roads, int[] traps) {
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] r : roads)
                addLink(graph, r[0], r);
            boolean[] visited = new boolean[n + 1];
            PriorityQueue<Location> queue = new PriorityQueue<>((a, b) -> a.distance - b.distance);
            queue.add(new Location(start, 0));
            while (queue.size() > 0) {
                Location p = queue.remove();
                if (p.no == end) return p.distance;
                if (visited[p.no]) continue;
                visited[p.no] = true;

                List<int[]> links = graph.get(p.no);
                if (links == null) continue;
                for (int[] r : links)
                    queue.add(new Location(r[1], p.distance + r[2]));
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
