package baekjoon.b1651;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    @SuppressWarnings("unchecked")
    static Map<String, Integer>[] A = new HashMap[51];
    static List<Integer> B = new ArrayList<>();

    static int sum(List<Integer> list) {
        int sum = 0;
        for (int i : list)
            sum += i;
        return sum;
    }

    static int sameCount(int n) {
        int max = 0;
        for (String s : A[n].keySet()) {
            int len = A[n].get(s);
            if (len > max) max = len;
        }
        return max;
    }

    @SuppressWarnings("unused")
    static int solution() {
        for (int n = 1; n <= 150; ++n) {
            if (sameCount(n) >= 3) return n;
            for (int n1 = 1; n1 <= n/2; ++n1) {
                int n2 = n - n1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        for (int i = 1; i < A.length; ++i)
            A[i] = new HashMap<>();
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            for (int i = 0; i < N; ++i) {
                String s = scanner.next();
                if (s.equals("-1")) {
                    System.out.println(0);
                    return;
                }
                int index = s.length();
                Integer count = A[index].get(s);
                if (count == null) count = 0;
                A[index].put(s, count + 1);
            }
            for (int i = 0; i < A.length; ++i)
                if (A[i].size() > 0) B.add(i);
        }
    }
}