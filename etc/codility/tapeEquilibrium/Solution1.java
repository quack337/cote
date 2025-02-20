package net.skhu.codility.tapeEquilibrium;

public class Solution1 {

    public static int solution(int[] A) {        
        int sum = 0;
        for (int i = 0; i < A.length; ++i)
            sum += A[i];
        
        int sum1 = 0, difference = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; ++i) {
            sum1 += A[i];
            int temp = Math.abs((sum - sum1) - sum1);
            if (temp < difference) 
                difference = temp;
        }
        return difference;
    }
    
    public static void main(String[] args) {
        //int[] A = {3, 1, 2, 4, 3};
        int[] A = {-1000, 1000};
        int difference = solution(A);
        System.out.println(difference);
    }
}
