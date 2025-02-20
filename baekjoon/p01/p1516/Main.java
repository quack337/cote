package baekjoon.p01.p1516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Building {
        int 건설시간, 건설총시간 = -1;
        List<Building> 선행건물목록 = new ArrayList<>();
    }

    static Building[] 건물목록;

    static int 선행건물건설시간(Building 건물) {
        int 최대값 = 0;
        for (Building 선행건물 : 건물.선행건물목록) {
            int 시간 = 건설총시간(선행건물);
            if (시간 > 최대값) 최대값 = 시간;
        }
        return 최대값;
    }

    static int 건설총시간(Building 건물) {
        if (건물.건설총시간 >= 0) return 건물.건설총시간;
        건물.건설총시간 = 건물.건설시간 + 선행건물건설시간(건물);
        return 건물.건설총시간;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        건물목록 = new Building[N];
        for (int i = 0; i < N; ++i)
            건물목록[i] = new Building();
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            건물목록[i].건설시간 = Integer.parseInt(tokenizer.nextToken());
            while (true) {
                int p = Integer.parseInt(tokenizer.nextToken());
                if (p == -1) break;
                건물목록[i].선행건물목록.add(건물목록[p - 1]);
            }
        }
        for (int i = 0; i < N; ++i)
            System.out.println(건설총시간(건물목록[i]));
    }
}
