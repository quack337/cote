package baekjoon.p01.p1799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main1 {
    static class Bishop {
        int row, col;

        public Bishop(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static boolean 놓을수있는가(int row, int col, List<Bishop> list) {
        if (map[row][col] != '1') return false;
        for (Bishop p : list)
            if (row - col == p.row - p.col || row + col == p.row + p.col)
                return false;
        return true;
    }

    static int N;
    static char[][] map;

    static int 경우의수(int index, List<Bishop> list) {
        if (index >= N * N) return list.size();
        int row = index / N, col = index % N;
        int count1 = 0, count2 = 0;
        count1 = 경우의수(index + 1, list);
        if (놓을수있는가(row, col, list)) {
            Bishop p = new Bishop(row, col);
            list.add(p);
            count2 = 경우의수(index + 1, list);
            list.remove(list.size() - 1);
        }
        return Math.max(count1, count2);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        map = new char[N][];
        for (int i = 0; i < N; ++i)
            map[i] = reader.readLine().replaceAll(" ", "").toCharArray();

        System.out.println(경우의수(0, new ArrayList<Bishop>()));
    }
}