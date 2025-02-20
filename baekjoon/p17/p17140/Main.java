package baekjoon.p17.p17140;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

    static class EntryComparator implements Comparator<Map.Entry<Integer,Integer>> {
        @Override
        public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
            int r;
            if ((r = e1.getValue() - e2.getValue()) != 0) return r;
            if ((r = e1.getKey() - e2.getKey()) != 0) return r;
            return 0;
        }
    }

    static EntryComparator comparator = new EntryComparator();

    @SuppressWarnings("unchecked")
    static int[] 정렬(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            if (i == 0) continue;
            Integer count = map.get(i);
            map.put(i, count == null ? 1 : count + 1);
        }
        Map.Entry<Integer, Integer>[] b = map.entrySet().toArray(new Map.Entry[map.size()]);
        Arrays.sort(b, comparator);
        int[] c = new int[b.length * 2];
        for (int i = 0; i < b.length; ++i) {
            c[i * 2] = b[i].getKey();
            c[i * 2 + 1] = b[i].getValue();
        }
        return c;
    }

    static void 크기조정(int[][] a) {
        int max = 0;
        for (int i = 0; i < a.length; ++i)
            if (a[i].length > max) max = a[i].length;
        if (max > 100) max = 100;
        for (int i = 0; i < a.length; ++i)
            a[i] = Arrays.copyOf(a[i], max);
    }

    static int[][] R연산(int[][] a) {
        int[][] b = new int[a.length][];
        for (int i = 0; i < a.length; ++i)
            b[i] = 정렬(a[i]);
        크기조정(b);
        return b;
    }

    static int[][] 회전(int[][] a) {
        int[][] b = new int[a[0].length][a.length];
        for (int r = 0; r < a.length; ++r)
            for (int c = 0; c < a[0].length; ++c)
                b[c][r] = a[r][c];
        return b;
    }

    static int[][] C연산(int[][] a) {
        a = 회전(a);
        a = R연산(a);
        return 회전(a);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int 목표_행 = scanner.nextInt() - 1;
            int 목표_열 = scanner.nextInt() - 1;
            int 목표_수 = scanner.nextInt();
            int[][] a = new int[3][3];
            for (int r = 0; r < 3; ++r)
                for (int c = 0; c < 3; ++c)
                    a[r][c] = scanner.nextInt();

            for (int i = 0; i <= 100; ++i) {
                if (a.length > 목표_행 && a[0].length > 목표_열 && a[목표_행][목표_열] == 목표_수) {
                    System.out.println(i);
                    return;
                }
                if (a.length >= a[0].length)
                    a = R연산(a);
                else
                    a = C연산(a);
            }
            System.out.println(-1);
        }
    }
}

