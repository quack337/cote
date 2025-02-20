package net.skhu.codility.oddOccurrencesInArray;

public class Solution3 {

    static int solution(int[] A) {
        int r = 0;
        for (int i : A)
            r ^= i;
        return r;
    }
    
    public static void main(String[] args) {
        int[] a = { 1, 32, 535, 6875, 71234, 1, 32, 6875, 71234, 535, 71234 };
        int n = solution(a);
        System.out.println(n);
    }
}
