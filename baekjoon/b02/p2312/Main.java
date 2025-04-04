package baekjoon.b02.p2312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Main {
    static List<Integer> 소인수분해(int value) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= value; ++i) {
            while (value % i == 0) {
                value /= i;
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            int N = Integer.parseInt(reader.readLine());
            List<Integer> list = 소인수분해(N);
            TreeMap<Integer,Integer> map = new TreeMap<>();
            for (int i : list) {
                Integer count = map.get(i);
                if (count == null) count = 0;
                map.put(i, count + 1);
            }
            for (int i : map.keySet())
                System.out.printf("%d %d\n", i, map.get(i));
        }
    }
}