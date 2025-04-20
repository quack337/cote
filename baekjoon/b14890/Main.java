package baekjoon.b14890;
import java.util.Scanner;

public class Main {

    static int N, L;
    static int[][] 지도;

    // 현재위치 왼쪽에 오르막 경사로를 건설할 때는, 왼쪽에 이미 건설한 경사로와 중복되는지 검사해야한다.
    static boolean 가로방향_오르막_경사로_건설(int 행, int 경사로끝열, boolean[] 경사로) {
        int 경사로시작열 = 경사로끝열 - L + 1;
        if (경사로시작열 < 0 || 경사로[경사로시작열]) return false;
        경사로[경사로시작열] = true;
        for (int 열 = 경사로시작열 + 1; 열 <= 경사로끝열; ++열) {
            if (열 >= 지도[행].length || 경사로[열] || 지도[행][열] != 지도[행][경사로시작열])
                return false;
            경사로[열] = true;
        }
        return true;
    }

    // 현재위치 오른쪽에 내리막 경사로를 건설할 때는, 왼쪽에 이미 건설한 경사로를 걱정할 필요 없다.
    static boolean 가로방향_내리막_경사로_건설(int 행, int 경사로시작열, boolean[] 경사로) {
        int 경사로끝열 = 경사로시작열 + L - 1;
        if (경사로끝열 >=  N) return false;
        경사로[경사로시작열] = true;
        for (int 열 = 경사로시작열 + 1; 열 <= 경사로끝열; ++열) {
            if (열 >= 지도[행].length || 지도[행][열] != 지도[행][경사로시작열])
                return false;
            경사로[열] = true;
        }
        return true;
    }

    static boolean 가로방향_도로건설(int 행) {
        boolean[] 경사로 = new boolean[N];
        for (int 열 = 1; 열 < N; ++열) {
            int 높이차이 = 지도[행][열] - 지도[행][열 - 1];
            if (높이차이 > 1 || 높이차이 < -1)
                return false;
            else if (높이차이 == 1) {
                if (가로방향_오르막_경사로_건설(행, 열-1, 경사로) == false)
                    return false;
            } else if (높이차이 == -1) {
                if (가로방향_내리막_경사로_건설(행, 열, 경사로) == false)
                    return false;
            }
        }
        return true;
    }

    static void 회전90도(int[][] 지도) {
        for (int 행 = 0; 행 < 지도.length; ++행)
            for (int 열 = 행 + 1; 열 < 지도.length; ++열) {
                int 임시 = 지도[행][열];
                지도[행][열] = 지도[열][행];
                지도[열][행] = 임시;
            }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            N = scanner.nextInt();
            L = scanner.nextInt();
            지도 = new int[N][];
            for (int 행 = 0; 행 < N; ++행) {
                지도[행] = new int[N];
                for (int 열 = 0; 열 < N; ++열)
                    지도[행][열] = scanner.nextInt();
            }
            int 도로 = 0;
            for (int 행 = 0; 행 < N; ++행)
                if (가로방향_도로건설(행)) ++도로;
            회전90도(지도); // 세로 방향 도로를 건설하기 위해, 지도를 회전함.
            for (int 행 = 0; 행 < N; ++행)
                if (가로방향_도로건설(행)) ++도로;
            System.out.println(도로);
        }
    }
}