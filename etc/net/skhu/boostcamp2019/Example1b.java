package net.skhu.boostcamp2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Example1b {
    static int[] toArray(List<Integer> list) {
        int[] a = new int[list.size()];
        int index = 0;
        for (int i : list)
            a[index++] = i;
        return a;
    }

    // 수행시간 O(NlogM)
    //   N : 입력 배열의 크기
    //   M : TreeMap의 크기 = 입력 배열에 들어있는 수의 종류.
    static int[] solution(int[] arr) {
        TreeMap<Integer,Integer> counts = new TreeMap<>();
        for (int i : arr) {
            Integer count = counts.get(i);
            if (count == null) count = 0;
            counts.put(i, count + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : counts.keySet())
            if (counts.get(i) > 1) list.add(counts.get(i));
        return list.size() > 0 ? toArray(list) : new int[] { -1 };
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 3, 3, 4, 4};
        int[] a2 = {3, 2, 4, 4, 2, 5, 2, 5, 5};
        int[] a3 = {3, 5, 7, 9, 1};
        System.out.println(Arrays.toString(solution(a1)));
        System.out.println(Arrays.toString(solution(a2)));
        System.out.println(Arrays.toString(solution(a3)));
    }
}