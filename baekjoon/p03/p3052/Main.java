package baekjoon.p03.p3052;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        var result = new HashMap<Integer, Boolean>();
        for (int i = 0; i < 10; ++i) {
            int 값 = scanner.nextInt();
            int 나머지 = 값 % 42;
            result.put(나머지, true);
        }
        System.out.println(result.size());
        scanner.close();
    }
}