package baekjoon.p02.p2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(reader.readLine());
        Arrays.sort(A);
        for (int i : A)
            System.out.println(i);
    }
}