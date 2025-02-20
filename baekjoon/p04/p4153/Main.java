package baekjoon.p04.p4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] A = new int[3];
        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            A[0] = Integer.parseInt(tokenizer.nextToken());
            A[1] = Integer.parseInt(tokenizer.nextToken());
            A[2] = Integer.parseInt(tokenizer.nextToken());
            Arrays.sort(A);
            if (A[2]==0) break;
            System.out.println((A[0]*A[0] + A[1]*A[1] == A[2]*A[2]) ? "right" : "wrong");
        }
    }
}
