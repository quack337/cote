package baekjoon.p11.p11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main1 {
    static List<int[]> result = new ArrayList<>();

    static void move(int n, int from, int to) {
        result.add(new int[] {from, to});
    }

    static void hanoi(int n, int from, int to, int temp) {
        if (n == 0) return;
        hanoi(n - 1, from, temp, to);
        move(n, from, to);
        hanoi(n - 1, temp, to, from);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        hanoi(N, 1, 3, 2);
        System.out.println(result.size());
        for (int[] a : result)
            System.out.printf("%d %d\n", a[0], a[1]);
    }
}