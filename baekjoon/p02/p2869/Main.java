package baekjoon.p02.p2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long A = Long.parseLong(tokenizer.nextToken());
        long B = Long.parseLong(tokenizer.nextToken());
        long V = Long.parseLong(tokenizer.nextToken());
        System.out.println((V - B - 1) / (A - B) + 1);
    }
}