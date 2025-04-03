package programmers.e12981;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

    static class Solution {

char 첫문자(String s) { return s.charAt(0); }
char 끝문자(String s) { return s.charAt(s.length() - 1); }

public int[] solution(int n, String[] words) {
    var 사용된단어 = new HashSet<String>();
    int 사람 = 1, 라운드 = 1, index = 0;
    char 문자 = 첫문자(words[0]);
    while (true) {
        if (첫문자(words[index]) != 문자) break;
        문자 = 끝문자(words[index]);
        if (사용된단어.contains(words[index])) break;
        else 사용된단어.add(words[index]);
        ++사람;
        if (사람 > n) { 사람 = 1; ++라운드; }
        ++index;
        if (index == words.length) return new int[] {0, 0};

    }
    return new int[] { 사람, 라운드 };
}
    }

    public static void main(String[] args) {
        var s = new Solution();
        var a = new String[] { "tank","kick","know","wheel","land","dream","mother","robot","tank" };
        System.out.println(Arrays.toString(s.solution(3, a)));
        a = new String[] { "hello","observe","effect","take","either","recognize","encourage","ensure",
                "establish","hang","gather","refer","reference","estimate","executive" };
        System.out.println(Arrays.toString(s.solution(5, a)));
        a = new String[] { "hello","one","even","never","now","world","draw" };
        System.out.println(Arrays.toString(s.solution(2, a)));
    }

}