package net.skhu.codility.frogJmp;

public class Solution1 {
    
    public static int solution(int X, int Y, int D) {
        int distance = Y - X;
        return (distance + D - 1) / D;
    }
    
    public static void main(String[] args) {
        int value = solution(0, 11, 5);
        System.out.println(value);
    }

}
