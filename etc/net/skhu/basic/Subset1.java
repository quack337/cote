package net.skhu.basic;

import java.util.Arrays;

public class Subset1 {

    static void solution(String[] A, int index) {
        if (index >= A.length) {
            System.out.println(Arrays.toString(A));
            return;
        }

        A[index] = "0";
        solution(A, index + 1);

        A[index] = "1";
        solution(A, index + 1);
    }

    public static void main(String[] args) {
        solution(new String[3], 0);
    }

}