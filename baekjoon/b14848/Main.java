package baekjoon.b14848;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static long N;
    static int K;
    static int[] A;

    static long 최대공약수(long a, long b){
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static long 최소공배수(long a, long b) {
        return a * b / 최대공약수(a, b);
    }

    static long 최소공배수(ArrayList<Integer> a) {
        long result = a.get(0);
        for (int i = 1; i < a.size(); ++i)
            result = 최소공배수(result, a.get(i));
        return result;
    }

    static long 배수집합크기(long m) {
        return N / m;
    }

    static long 교집합크기(ArrayList<Integer> selected) {
        long lcm = 최소공배수(selected);
        return 배수집합크기(lcm);
    }

    static long nCr조합(int r, int index, ArrayList<Integer> selected) {
        if (selected.size() == r)
            return 교집합크기(selected);
        long result = 0;
        if (A.length - index > r - selected.size())
            result += nCr조합(r, index+1, selected);

        selected.add(A[index]);
        result += nCr조합(r, index+1, selected);
        selected.remove(selected.size() - 1);
        return result;
    }

    static long 합집합의크기() {
        long result = 0;
        for (int i = 1; i <= K; ++i) {
            long t = nCr조합(i, 0, new ArrayList<Integer>());
            result += t * (i % 2 == 0 ? -1 : 1);
        }
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Long.parseLong(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());
        A = new int[K];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < K; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        long result = 합집합의크기();
        System.out.println(N - result);
    }
}