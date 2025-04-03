package line.e2022;

public class Main5 {

    static int 최대공약수(int a, int b){
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static int[] solution(int[][] fee) {
        int b = fee[0][1];
        for (int[] f : fee)
            b = 최대공약수(b, f[1]);

        return null;
    }

    public static void main(String[] args) {
    }
}