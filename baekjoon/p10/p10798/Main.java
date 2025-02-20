package baekjoon.p10.p10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] A = new String[5];
        int maxLength = 0;
        for (int i = 0; i < A.length; ++i) {
            A[i] = reader.readLine();
            if (A[i].length() > maxLength) maxLength = A[i].length();
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < maxLength; ++i) {
            for (String s : A) {
                if (s.length() <= i) continue;
                builder.append(s.charAt(i));
            }
        }
        System.out.println(builder.toString());
    }
}
