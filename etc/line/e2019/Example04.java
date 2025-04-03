package line.e2019;

import java.io.IOException;
import java.util.Scanner;

public class Example04 {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            String s1 = scanner.next();
            String s2 = scanner.next();

            int S = 0;
            boolean[] digit = new boolean[10];

            for (int i = 0; i < s1.length(); ++i) {
                if (s1.charAt(i) == s2.charAt(i))
                    ++S;
                digit[s1.charAt(i) - '0'] = true;
            }
            if (S > 0)
                System.out.print(S + "S");

            int B = 0;
            for (int i = 0; i < s2.length(); ++i)
                if (digit[s2.charAt(i) - '0'] && s1.charAt(i) != s2.charAt(i))
                    B++;
            if (B > 0)
                System.out.print(B + "B");

            if (S == 0 && B == 0)
                System.out.print("out");
        }
    }
}