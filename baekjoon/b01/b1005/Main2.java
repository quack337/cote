package baekjoon.b01.b1005;

import java.util.Scanner;

public class Main2 {

    static class Precedence {
        int 선행건물, 목표건물;
    }

    static int 건물수, 순서수, 목표건물;
    static int[] 건설시간;
    static Precedence[] 건물순서;
    static int[] 건설총시간;


    static int 선행건물건설시간(int 건물) {
        int 최대값 = 0;
        for (Precedence 순서 : 건물순서) {
            if (순서.목표건물 == 건물) {
                int 시간 = 건설총시간(순서.선행건물);
                if (시간 > 최대값) 최대값 = 시간;
            }
        }
        return 최대값;
    }

    static int 건설총시간(int 건물) {
        if (건설총시간[건물] > 0) return 건설총시간[건물];
        return 건설총시간[건물] = 건설시간[건물] + 선행건물건설시간(건물);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();
            for (int t = 0; t < T; ++t) {
                건물수 = scanner.nextInt();
                순서수 = scanner.nextInt();
                건설시간 = new int[건물수];
                건설총시간 = new int[건물수];
                for (int i = 0; i < 건물수; ++i)
                    건설시간[i] = scanner.nextInt();
                건물순서 = new Precedence[순서수];
                for (int i = 0; i < 순서수; ++i) {
                    건물순서[i] = new Precedence();
                    건물순서[i].선행건물 = scanner.nextInt() - 1;
                    건물순서[i].목표건물 = scanner.nextInt() - 1;
                }
                목표건물 = scanner.nextInt() - 1;
                System.out.println(건설총시간(목표건물));
            }
        }
    }
}