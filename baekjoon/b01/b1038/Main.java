package baekjoon.b01.b1038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Long> 목록 = new ArrayList<>();

    static void 감소하는수열생성(int digit, int length, long number) {
        if (length == 0) {
            목록.add(number);
            return;
        }
        if (digit >= length)
            감소하는수열생성(digit - 1, length, number);
        감소하는수열생성(digit - 1, length - 1, number * 10 + digit);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        for (int length = 1; length <= 10; ++length)
            감소하는수열생성(9, length, 0);
        System.out.println(목록.size());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        long answer = (N < 목록.size()) ? 목록.get(N) : -1;
        System.out.println(answer);
    }
}