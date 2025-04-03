package net.skhu.boostcamp2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example1a {
    static final int MAX = 100;

    static int[] toArray(List<Integer> list) {
        int[] a = new int[list.size()];
        int index = 0;
        for (int i : list)
            a[index++] = i;
        return a;
    }

    // 수행시간 O(N)
    static int[] solution(int[] arr) {
        int[] counts = new int[MAX];
        for (int i : arr)
            ++counts[i];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : counts)
            if (i > 1) list.add(i);
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