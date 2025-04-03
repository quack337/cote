package baekjoon.p14.p14888;

import java.util.Scanner;

public class Main {

    static final int 덧셈 = 0, 뺄셈 = 1, 곱셈 = 2, 나눗셈 = 3;
    static int 최대값 = Integer.MIN_VALUE, 최소값 = Integer.MAX_VALUE;

    static int 계산(int[] 숫자, byte[] 연산자) {
        int 결과 = 숫자[0];
        for (int i = 0; i < 연산자.length; ++i) {
            switch (연산자[i]) {
            case 덧셈: 결과 += 숫자[i + 1]; break;
            case 뺄셈: 결과 -= 숫자[i + 1]; break;
            case 곱셈: 결과 *= 숫자[i + 1]; break;
            case 나눗셈: 결과 /= 숫자[i + 1]; break;
            }
        }
        return 결과;
    }

    static void 계산(int[] 숫자, byte[] 연산자, int index, int 덧셈수, int 뺄셈수, int 곱셈수, int 나눗셈수) {
        if (index >= 연산자.length) {
            int 값 = 계산(숫자, 연산자);
            if (값 > 최대값) 최대값 = 값;
            if (값 < 최소값) 최소값 = 값;
            return;
        }
        if (덧셈수 > 0) {
            연산자[index] = 덧셈;
            계산(숫자, 연산자, index + 1, 덧셈수-1, 뺄셈수, 곱셈수, 나눗셈수);
        }
        if (뺄셈수 > 0) {
            연산자[index] = 뺄셈;
            계산(숫자, 연산자, index + 1, 덧셈수, 뺄셈수-1, 곱셈수, 나눗셈수);
        }
        if (곱셈수 > 0) {
            연산자[index] = 곱셈;
            계산(숫자, 연산자, index + 1, 덧셈수, 뺄셈수, 곱셈수-1, 나눗셈수);
        }
        if (나눗셈수 > 0) {
            연산자[index] = 나눗셈;
            계산(숫자, 연산자, index + 1, 덧셈수, 뺄셈수, 곱셈수, 나눗셈수-1);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int[] 숫자 = new int[N];
            for (int i = 0; i < N; ++i)
                숫자[i] = scanner.nextInt();
            int 덧셈 = scanner.nextInt();
            int 뺄셈 = scanner.nextInt();
            int 곱셈 = scanner.nextInt();
            int 나눗셈 = scanner.nextInt();
            계산(숫자, new byte[N-1], 0, 덧셈, 뺄셈, 곱셈, 나눗셈);
            System.out.printf("%d\n%d\n", 최대값, 최소값);
        }
    }
}