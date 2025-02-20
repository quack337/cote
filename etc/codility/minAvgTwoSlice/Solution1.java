package net.skhu.codility.minAvgTwoSlice;

public class Solution1 {
    
    static double average(int[] A, int start, int end) {
        double sum = 0;
        for (int i = start; i <= end; ++i)
            sum += A[i];
        return sum / (end - start + 1);
    }
    
    public static int solution(int[] A) {
        double minAvg = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < A.length; ++i)
            for (int j = i + 1; j < A.length; ++j) {
                double avg = average(A, i, j);
                if (avg < minAvg) {
                    minAvg = avg;
                    start = i;
                }
            }
        return start;                
    }
    
    public static void main(String[] args) {
        int[] A = {4, 2, 2, 5, 1, 5, 8};
        System.out.println(solution(A));
    }

}
