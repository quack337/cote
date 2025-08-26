package baekjoon.b1005.old;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main3 {

    static class Building {
        int 건설시간, 건설총시간;
        List<Building> 선행건물목록 = new ArrayList<>();
    }

    static Building[] 건물목록;

    static int 선행건물건설시간(Building 건물, Set<Building> 경로) {
        int 최대값 = 0;
        for (Building 선행건물 : 건물.선행건물목록) {
            int 시간 = 건설총시간(선행건물, 경로);
            if (시간 > 최대값) 최대값 = 시간;
        }
        return 최대값;
    }

    static int 건설총시간(Building 건물, Set<Building> 경로) {
        if (경로.contains(건물)) return Integer.MAX_VALUE;
        if (건물.건설총시간 > 0) return 건물.건설총시간;
        경로.add(건물);
        건물.건설총시간 = 건물.건설시간 + 선행건물건설시간(건물, 경로);
        경로.remove(건물);
        return 건물.건설총시간;

    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();
            for (int t = 0; t < T; ++t) {
                int 건물수 = scanner.nextInt();
                int 순서수 = scanner.nextInt();
                건물목록 = new Building[건물수];
                for (int i = 0; i < 건물수; ++i) {
                    Building 건물 = new Building();
                    건물.건설시간 = scanner.nextInt();
                    건물목록[i] = 건물;
                }
                for (int i = 0; i < 순서수; ++i) {
                    int 선행건물 = scanner.nextInt() - 1;
                    int 목표건물 = scanner.nextInt() - 1;
                    건물목록[목표건물].선행건물목록.add(건물목록[선행건물]);
                }
                int 목표 = scanner.nextInt() - 1;
                System.out.println(건설총시간(건물목록[목표], new HashSet<>()));
            }
        }
    }
}