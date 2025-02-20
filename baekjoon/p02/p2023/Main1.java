package baekjoon.p02.p2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main1 {

    static final int[] 한자리소수 = {2, 3, 5, 7, 9 };
    static final int[] 뒷자리수 = {1, 3, 7, 9 };
    static int N;
    static ArrayList<Integer> 답 = new ArrayList<>();

    static boolean isPrime(int value) {
        int limit = (int)Math.sqrt(value);
        for (int i = 2; i <= limit; ++i)
            if (value % i == 0)
                return false;
        return true;
    }


    static void DFS(int 값, int 길이) {
        if (isPrime(값) == false) return;
        if (길이 == N) {
            답.add(값);
            return;
        }
        for (int i : 뒷자리수)
            DFS(값 * 10 + i, 길이 + 1);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        for (int i : 한자리소수)
            DFS(i, 1);
        Collections.sort(답);
        for (int 값 : 답)
            System.out.println(값);
    }
}
