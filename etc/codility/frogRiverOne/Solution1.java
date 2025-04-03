package codility.frogriverone;

public class Solution1 {

    public static int solution(int X, int[] A) {
        boolean[] river = new boolean[X];
        int count = 0;

        for (int i = 0; i < A.length; ++i) {
            int index = A[i] - 1;
            if (river[index] == false) {
                river[index] = true;
                ++count;
                if (count >= X) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A1 = {1, 3, 1, 4, 2, 3, 5, 4 };
        int[] A2 = {1, 3, 1, 4, 2, 3, 2, 4 };
        int[] A3 = {1};

        System.out.println(solution(5, A1));
        System.out.println(solution(5, A2));
        System.out.println(solution(1, A3));
        System.out.println(solution(2, A3));
    }

}
