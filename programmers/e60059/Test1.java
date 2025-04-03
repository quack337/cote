package programmers.e60059;

public class Test1 {

    static int get(int[][] a, int 회전, int 행, int 열) {
        if (회전 == 1) { // 90도
            int t = 행;
            행 = a.length - 1 - 열;
            열 = t;
        } else if (회전 == 2) { // 180 도
            행 = a.length - 1 - 행;
            열 = a.length - 1 - 열;
        } else if (회전 == 3) { // 270 도
            int t = 행;
            행 = 열;
            열 = a.length - 1 - t;
        }
        return a[행][열];
    }

    static void print(int[][] a, int 회전) {
        for (int 행 = 0; 행 < a.length; ++행) {
            for (int 열 = 0; 열 < a.length; ++열)
                System.out.printf("%2d ", get(a, 회전, 행, 열));
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < 4; ++i)
            print(a, i);
    }

}