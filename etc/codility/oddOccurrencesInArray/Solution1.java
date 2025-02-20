package net.skhu.codility.oddOccurrencesInArray;

import java.util.Arrays;

public class Solution1 {

    static int solution(int[] A) {
        int prev = -1, count = 0;
        Arrays.sort(A);
        for (int i : A)
            if (i != prev) {
                if (count % 2 == 1) return prev;
                prev = i;
                count = 1;
            } else 
                ++count;
        if (count % 2 == 1) return prev;
        return -1;
    }
    
    public static void main(String[] args) {
        int[] a = { 1, 32, 535, 6875, 71234, 1, 32, 6875, 71234, 535, 32 };
        int n = solution(a);
        System.out.println(n);
    }
}

