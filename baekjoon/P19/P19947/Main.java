package baekjoon.P19.P19947;

import java.util.Scanner;

public class Main {

    static int solution(int 기간, int 금액) {
        if (기간 == 0) return 금액;
        int 최대금액 = 0;
        if (기간 >= 1) 최대금액 = Math.max(최대금액, solution(기간 - 1, (int)(금액 * 1.05)));
        if (기간 >= 3) 최대금액 = Math.max(최대금액, solution(기간 - 3, (int)(금액 * 1.2)));
        if (기간 >= 5) 최대금액 = Math.max(최대금액, solution(기간 - 5, (int)(금액 * 1.35)));
        return 최대금액;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int 금액 = scanner.nextInt();
        int 기간 = scanner.nextInt();
        System.out.println(solution(기간, 금액));
        scanner.close();
    }
}
