package baekjoon.p01.p1000;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        System.out.println(A + B);
        scanner.close();
    }
}