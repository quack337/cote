package codility.missinginteger;

import java.util.HashSet;

public class Solution1 {

    public static int solution(int[] A) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i : A)
            set.add(i);
        for (int i = 1; i < Integer.MAX_VALUE; ++i)
            if (set.contains(i) == false) return i;
        return 0;
    }

    public static void main(String[] args) {
        int[] A = { 2 };

        int temp = solution(A);
        System.out.println(temp);
    }

}