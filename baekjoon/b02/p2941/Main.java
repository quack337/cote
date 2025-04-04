package baekjoon.b02.p2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] pattern = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        for (String p : pattern)
            s = s.replaceAll(p, " ");
        System.out.println(s.length());
    }
}