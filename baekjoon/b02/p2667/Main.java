package baekjoon.b02.p2667;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static char[][] map;

    static int DFS(int r, int c, char no) {
        if (r < 0 || r >= map.length) return 0;
        if (c < 0 || c >= map[0].length) return 0;
        if (map[r][c] != '1') return 0;
        map[r][c] = no;
        int count = 1;
        count += DFS(r - 1, c, no);
        count += DFS(r + 1, c, no);
        count += DFS(r, c - 1, no);
        count += DFS(r, c + 1, no);
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        map = new char[N][];
        for (int r = 0; r < N; ++r)
            map[r] = scanner.next().toCharArray();
        ArrayList<Integer> result = new ArrayList<>();
        char no = '2';
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (map[r][c] == '1')
                    result.add(DFS(r, c, no++));
        Collections.sort(result);
        System.out.println(result.size());
        for (int i : result)
            System.out.println(i);
        scanner.close();
    }
}