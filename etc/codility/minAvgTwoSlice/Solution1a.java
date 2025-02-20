package net.skhu.codility.minAvgTwoSlice;

import java.util.Arrays;
import java.util.Random;

public class Solution1a {
    
    static double average(int[] A, int start, int end) {
        double sum = 0;
        for (int i = start; i <= end; ++i)
            sum += A[i];
        return sum / (end - start + 1);
    }
    
    public static int[] solution(int[] A) {
        double minAvg = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        for (int i = 0; i < A.length; ++i)
            for (int j = i + 1; j < A.length; ++j) {
                double avg = average(A, i, j);
                if (avg < minAvg) {
                    minAvg = avg;
                    start = i;
                    end = j;
                }
            }
        return Arrays.copyOfRange(A, start, end + 1);                
    }
    
    static Random random = new Random();
    
    static int[] createRandomIntArray(int count) {
        int[] A = new int[count];
        for (int j = 0; j < count; ++j)
            A[j] = random.nextInt(20001) - 10000;
        return A;
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 1000; ++i) {
            int[] A = createRandomIntArray(20);        
            System.out.println(Arrays.toString(solution(A)));
        }
    }

}
