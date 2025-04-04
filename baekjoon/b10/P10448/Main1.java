package baekjoon.b10.P10448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main1 {

    static ArrayList<Integer> 삼각수생성(int max) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 1, sum = 1;
        while (sum <= max) {
            list.add(sum);
            ++i;
            sum = sum + i;
        }
        return list;
    }

    static ArrayList<Integer> 삼각수 = 삼각수생성(1000);
    static int K;

    static boolean check(int index, int count, int sum) {
        if (sum == K && count == 3) return true;
        if (index >= 삼각수.size()) return false;
        for (int i = 1; i <= 3; ++i) {
            if (count <= 3 - i && sum + 삼각수.get(index) * i <= K)
                if (check(index + 1, count + i, sum + 삼각수.get(index) * i))
                    return true;
        }
        return check(index + 1, count, sum);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int test = 0; test < T; ++test) {
            K = Integer.parseInt(reader.readLine());
            System.out.println(check(0, 0, 0) ? 1: 0);
        }
    }
}