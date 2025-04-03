package baekjoon.p02.p2983;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static class Location implements Comparable<Location> {
        long x, y;

        public Location(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Location p) {
            long r = this.x - p.x;
            if (r != 0) return (int)r;
            return (int)(this.y - p.y);
        }

        public long key1() { return x - y; }
        public long key2() { return x + y; }
    }

    static HashMap<Long, ArrayList<Location>> map1 = new HashMap<>(); // x - y 값이 키
    static HashMap<Long, ArrayList<Location>> map2 = new HashMap<>(); // x + y 값이 키
    static Location current = null; // 개구리의 현재 위치

    static void add(Location location) {
        if (current == null) current = location;
        ArrayList<Location> list1 = map1.get(location.key1());
        if (list1 == null) {
            list1 = new ArrayList<Location>();
            map1.put(location.key1(), list1);
        }
        list1.add(location);
        ArrayList<Location> list2 = map2.get(location.key2());
        if (list2 == null) {
            list2 = new ArrayList<Location>();
            map2.put(location.key2(), list2);
        }
        list2.add(location);
    }

    static void sort(HashMap<Long, ArrayList<Location>> map) {
        for (long key : map.keySet())
            Collections.sort(map.get(key));
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        String cmd = reader.readLine();
        for (int i = 0; i < N; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            long x = Long.parseLong(tokenizer.nextToken());
            long y = Long.parseLong(tokenizer.nextToken());
            add(new Location(x, y));
        }
        sort(map1);
        sort(map2);
        for (char c : cmd.toCharArray()) {
            ArrayList<Location> list1 = map1.get(current.key1());
            ArrayList<Location> list2 = map2.get(current.key2());
            int index1 = Collections.binarySearch(list1, current);
            int index2 = Collections.binarySearch(list2, current);

            if (c == 'A' || c == 'D') {
                if ((c == 'A' && index1 < list1.size() - 1) || // 점프할 다음 항목이 있는가
                    (c == 'D' && index1 > 0)) {                // 점프할 다음 항목이 있는가
                    current = list1.get(index1 + (c == 'A' ? 1 : -1)); // 점프할 다음 항목
                    list1.remove(index1); // 이전 위치 삭제
                    list2.remove(index2); // 이전 위치 삭제
                }
            } else if (c == 'B' || c == 'C') {
                if ((c == 'B' && index2 < list2.size() - 1) || // 점프할 다음 항목이 있는가
                    (c == 'C' && index2 > 0)) {                // 점프할 다음 항목이 있는가
                    current = list2.get(index2 + (c == 'B' ? 1 : -1)); // 점프할 다음 항목
                    list2.remove(index2); // 이전 위치 삭제
                    list1.remove(index1); // 이전 위치 삭제
                }
            }
        }
        System.out.printf("%d %d\n", current.x, current.y);
    }
}