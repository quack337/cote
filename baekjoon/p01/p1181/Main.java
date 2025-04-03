package baekjoon.p01.p1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Comparator<String> comparator = (s1, s2) -> {
            int r = s1.length() - s2.length();
            if (r != 0) return r;
            return s1.compareTo(s2);
        };
        TreeSet<String> set = new TreeSet<>(comparator);
        for (int i = 0; i < N; ++i)
            set.add(reader.readLine());
        for (String s : set)
            System.out.println(s);
    }
}