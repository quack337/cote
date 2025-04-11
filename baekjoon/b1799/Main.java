package baekjoon.b1799;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Bishop {
        int row, col;
    }

    static int N;
    static char[][] map;
    static Bishop[] bishop;
    static int bishopCount = 0;


    static boolean 놓을수있는가(int row, int col) {
        if (map[row][col] != '1') return false;
        for (int i = 0; i < bishopCount; ++i)
            if (row - col == bishop[i].row - bishop[i].col ||
                row + col == bishop[i].row + bishop[i].col)
                return false;
        return true;
    }

    static int 경우의수(int index, int evenOdd) {
        if (index >= N * N) return bishopCount;
        int row = index / N, col = index % N;
        if ((row + col) % 2 != evenOdd) return 경우의수(index + 1, evenOdd);
        int count1 = 0, count2 = 0;
        count1 = 경우의수(index + 1, evenOdd);
        if (놓을수있는가(row, col)) {
            bishop[bishopCount].row = row;
            bishop[bishopCount].col = col;
            ++bishopCount;
            count2 = 경우의수(index + 1, evenOdd);
            --bishopCount;
        }
        return Math.max(count1, count2);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        map = new char[N][];
        bishop = new Bishop[N * 2];
        for (int i = 0; i < bishop.length; ++i)
            bishop[i] = new Bishop();
        for (int i = 0; i < N; ++i)
            map[i] = reader.readLine().replaceAll(" ", "").toCharArray();

        System.out.println(경우의수(0, 0) + 경우의수(1, 1));
    }
}