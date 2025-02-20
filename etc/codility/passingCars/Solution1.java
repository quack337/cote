package net.skhu.codility.passingCars;

public class Solution1 {

    public static int solution(int[] A) {
        int count = 0, temp = 0;
        for (int i = A.length-1; i >= 0; --i) {
            if (A[i] == 1)
                ++temp;
            else {
                count += temp;
                if (count >= 1000000000) return -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] AA = new int[][] {
                {0, 1, 0, 1, 1},
                {0, 1, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 1, 1, 0}
        };

        for (int[] A : AA) {
            int temp = solution(A);
            System.out.println(temp);
        }
    }

}
