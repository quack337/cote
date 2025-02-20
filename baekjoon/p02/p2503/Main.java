package baekjoon.p02.p2503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 올바른 야구 수인지 확인한다.
    static boolean valid(char[] n) {
        return n[0] != n[1] && n[0] != n[2] && n[1] != n[2] &&
               n[0] != '0' && n[1] != '0' && n[2] != '0';
    }

    // n1, n2 두 수를 비교하여 strike, ball 값이 맞는지 확인한다
    static boolean check(char[] n1, char[] n2, int strike, int ball) {
        for (int i = 0; i < 3; ++i) {
            char c = n1[i];
            if (c == n2[i]) --strike;
            else if (c == n2[0] || c == n2[1] || c == n2[2])
                --ball;
        }
        return strike == 0 && ball == 0;
    }

    // n1과 numbers 배열의 각각의 수를 비교하여, strike, ball 값이 모두 맞는지 확인한다
    static boolean check(char[] n1, char[][] numbers, int[] strikes, int[] balls) {
        for (int i = 0; i < numbers.length; ++i)
            if (check(n1, numbers[i], strikes[i], balls[i]) == false)
                return false;
        return true;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        char[][] numbers = new char[N][];
        int[] strikes  = new int[N];
        int[] balls  = new int[N];
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            numbers[i] = tokenizer.nextToken().toCharArray();
            strikes[i] = Integer.parseInt(tokenizer.nextToken());
            balls[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int count = 0;
        for (int n = 123; n <= 987; ++n) {
            char[] n1 = String.valueOf(n).toCharArray();
            if (valid(n1) && check(n1, numbers, strikes, balls))
                ++count;
        }
        System.out.println(count);
    }
}
