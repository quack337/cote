package baekjoon.b17144;
import java.util.Scanner;

public class Main {

    static int[][] 방, 이동단위;
    static int 청정기1_행, 청정기2_행;

    static void 이동단위_계산() {
        for (int 행 = 0; 행 < 방.length; ++행)
            for (int 열 = 0; 열 < 방[0].length; ++열)
                이동단위[행][열] = 방[행][열] / 5;
    }

    static void 먼지이동(int 행0, int 열0, int 행1, int 열1) {
        if (행1 < 0 || 행1 >= 방.length) return;
        if (열1 < 0 || 열1 >= 방[0].length) return;
        if (방[행1][열1] == -1) return;
        방[행0][열0] -= 이동단위[행0][열0];
        방[행1][열1] += 이동단위[행0][열0];
    }

    static void 먼지확산() {
        int 행수 = 방.length, 열수 = 방[0].length;
        이동단위_계산();
        for (int 행 = 0; 행 < 행수; ++행)
            for (int 열 = 0; 열 < 열수; ++열) {
                먼지이동(행, 열, 행-1, 열);
                먼지이동(행, 열, 행+1, 열);
                먼지이동(행, 열, 행, 열-1);
                먼지이동(행, 열, 행, 열+1);
            }
    }

    static void 청정기1바람() {
        int 열수 = 방[0].length;
        for (int 행 = 청정기1_행 - 1; 행 > 0; --행)
            방[행][0] = 방[행-1][0];
        for (int 열 = 0; 열 < 열수 - 1; ++열)
            방[0][열] = 방[0][열+1];
        for (int 행 = 0; 행 < 청정기1_행; ++행)
            방[행][열수-1] = 방[행+1][열수-1];
        for (int 열 = 열수 - 1; 열 > 1; --열)
            방[청정기1_행][열] = 방[청정기1_행][열-1];
        방[청정기1_행][1] = 0;
    }

    static void 청정기2바람() {
        int 행수 = 방.length, 열수 = 방[0].length;
        for (int 행 = 청정기2_행 + 1; 행 < 행수 - 1; ++행)
            방[행][0] = 방[행+1][0];
        for (int 열 = 0; 열 < 열수 - 1; ++열)
            방[행수-1][열] = 방[행수-1][열+1];
        for (int 행 = 행수-1; 행 > 청정기2_행; --행)
            방[행][열수-1] = 방[행-1][열수-1];
        for (int 열 = 열수 - 1; 열 > 1; --열)
            방[청정기2_행][열] = 방[청정기2_행][열-1];
        방[청정기2_행][1] = 0;
    }

    static int 먼지합계() {
        int 합계 = 0;
        for (int 행 = 0; 행 < 방.length; ++행)
            for (int 열 = 0; 열 < 방[0].length; ++열)
                if (방[행][열] > 0)
                    합계 += 방[행][열];
        return 합계;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int 행수 = scanner.nextInt();
            int 열수 = scanner.nextInt();
            int 초 = scanner.nextInt();
            이동단위 = new int[행수][열수];
            방 = new int[행수][열수];
            for (int 행 = 0; 행 < 행수; ++행) {
                for (int 열 = 0; 열 < 열수; ++열) {
                    방[행][열] = scanner.nextInt();
                    if (방[행][열] == -1) {
                        if (청정기1_행 == 0) 청정기1_행 = 행;
                        else 청정기2_행 = 행;
                    }
                }
            }
            for (int i = 0; i < 초; ++i) {
                먼지확산();
                청정기1바람();
                청정기2바람();
            }
            System.out.println(먼지합계());
        }
    }
}