package baekjoon.b10.P10448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static ArrayList<Integer> 삼각수생성(int max) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0, sum = 0;
        while ((sum += ++i) <= max)
            list.add(sum);
        return list;
    }

    static ArrayList<Integer> 삼각수 = 삼각수생성(1000);

    static boolean check(int index, int count, int sum) {
        if (count == 3) return sum == 0;
        if (count > 3 || index >= 삼각수.size()) return false;
        for (int i = 0; i <= 3; ++i)
            if (check(index + 1, count + i, sum - 삼각수.get(index) * i))
                return true;
        return false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int test = 0; test < T; ++test) {
            int K = Integer.parseInt(reader.readLine());
            System.out.println(check(0, 0, K) ? 1: 0);
        }
    }
}