package codility.countdiv;

public class Solution1 {

    public static int solution(int A, int B, int K) {
        int count1 = A / K + 1;
        int count2 = B / K + 1;
        if (A % K == 0)
            --count1;
        return count2 - count1;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, 11, 2));
        System.out.println(solution(0, 1, 1));
        System.out.println(solution(0, 0, 2));
        System.out.println(solution(0, 2000000000, 1));
    }

}
