package baekjoon.p11.p11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; ++i)
            list.add(i);
        int index = 0;
        while (list.size() > 0) {
            index = (index + K - 1) % list.size();
            result.add(list.remove(index));
        }
        System.out.println(result.toString().replace('[','<').replace(']','>'));
    }
}