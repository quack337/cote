package baekjoon.p01.p1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] A = reader.readLine().trim().toCharArray();
        Arrays.sort(A);
        System.out.println(new StringBuilder(new String(A)).reverse());
    }
}