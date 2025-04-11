package baekjoon.b1152;
import java.util.Scanner;

public class Main {

    static int 단어수세기(String s) {
        boolean 알파벳을읽고있는중인가 = false;
        int 단어수 = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
                if (알파벳을읽고있는중인가 == false) {
                    알파벳을읽고있는중인가 = true;
                    ++단어수;
                }
            } else
                알파벳을읽고있는중인가 = false;
        }
        return 단어수;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
             String s = scanner.nextLine();
             System.out.println(단어수세기(s));
        }
    }
}