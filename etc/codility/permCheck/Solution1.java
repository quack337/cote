package codility.permcheck;

import java.util.HashSet;

public class Solution1 {

    public static int solution(int[] A) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i : A)
            set.add(i);
        for (int i = 1; i <= A.length; ++i)
            if (set.contains(i) == false) return 0;
        return 1;
    }

    public static void main(String[] args) {
        int[] A = { 1, 1 };

        int temp = solution(A);
        System.out.println(temp);
    }

}