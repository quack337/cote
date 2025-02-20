package baekjoon.p02.p2908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        String s1 = tokenizer.nextToken();
        String s2 = tokenizer.nextToken();
        int n1 = Integer.parseInt(new StringBuilder(s1).reverse().toString());
        int n2 = Integer.parseInt(new StringBuilder(s2).reverse().toString());
        System.out.println(n1 > n2 ? n1 : n2);
    }
}
