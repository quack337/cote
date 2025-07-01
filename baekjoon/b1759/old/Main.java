package baekjoon.b1759.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int 암호길이, C;
    static char[] A;

    static void print(String 암호) {
        int 자음수 = 0, 모음수 = 0;
        for (char c : 암호.toCharArray())
            if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') ++모음수;
            else ++자음수;
        if (모음수 >= 1 && 자음수 >= 2)
            System.out.println(암호);
    }

    static void 경우의수(int index, StringBuilder 선택) {
        if (선택.length() == 암호길이) {
            print(선택.toString());
            return;
        }
        if (index >= A.length) return;
        if (선택.length() == 0 || A[index]  > 선택.charAt(선택.length()-1)) {
            선택.append(A[index]);
            경우의수(index + 1, 선택);
            선택.deleteCharAt(선택.length()-1);
        }
        if (암호길이 - 선택.length() < A.length - index)
            경우의수(index + 1, 선택);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        암호길이 = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        A = reader.readLine().replaceAll(" ", "").toCharArray();
        Arrays.sort(A);
        경우의수(0, new StringBuilder());
    }
}