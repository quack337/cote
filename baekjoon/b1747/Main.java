package baekjoon.b1747;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isPrim;

    static void 소수찾기() {
        final int N = isPrim.length - 1;
        int limit = (int)Math.sqrt(N);
        for (int i = 2; i <= limit; ++i) {
            if (isPrim[i] == false) continue;
            for (int j = i * 2; j <= N; j += i)
                if (isPrim[j])
                    isPrim[j] = false;
        }
    }

    static boolean isPalindrome(int value) {
        String s = String.valueOf(value);
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            ++start; --end;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

        isPrim = new boolean[1003002];
        Arrays.fill(isPrim, true);
        isPrim[0] = isPrim[1] = false;
        소수찾기();

        for (int i = n; i <= isPrim.length - 1; ++i)
            if (isPrim[i] && isPalindrome(i)) {
                System.out.println(i);
                break;
            }
    }
}