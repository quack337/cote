package baekjoon.p09.p9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            Map<String,Integer> map = new HashMap<>();
            int N = Integer.parseInt(reader.readLine());
            for (int i = 0; i < N; ++i) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                String 이름 = tokenizer.nextToken();
                String 종류 = tokenizer.nextToken();
                Integer count = map.get(종류);
                if (count == null) count = 0;
                map.put(종류, count + 1);
            }
            int 곱 = 1;
            for (String key : map.keySet())
                곱 *= 1 + map.get(key);
            System.out.println(곱 - 1);
        }
    }
}
