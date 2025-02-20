package baekjoon.p05.p5618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int 최대공약수(int a, int b){
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static int 최대공약수(int... a) {
        int result = a[0];
        for (int i = 1; i < a.length; ++i)
            result = 최대공약수(result, a[i]);
        return result;
    }

    static List<Integer> 약수(int value) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= value; ++i)
            if (value % i == 0) result.add(i);
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] A = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i]= Integer.parseInt(tokenizer.nextToken());
        for (int i : 약수(최대공약수(A)))
            System.out.println(i);
    }
}
