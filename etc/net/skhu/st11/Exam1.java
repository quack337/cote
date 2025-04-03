// 2020-09-29
package net.skhu.st11;

public class Exam1 {

    // O(N)
    public static int solution(String s) {
        int answer = 0;
        int count = 0; // 현재 구간에서 a 문자의 수
        for (char c : s.toCharArray()) {
            if (c != 'a') {
                answer += 2 - count; // 이 구간에 2 - count 개의 a 문자를 삽입할 수 있다.
                count = 0; // 현재 구간이 끝났다
            } else {
                ++count; // a 문자 발견
                if (count == 3)
                    return -1;
            }
        }
        answer += 2 - count; // 마지막 구간에 2 - count 개의 a 문자를 삽입할 수 있다.
        return answer;
    }

    public static void main(String[] args) {
        // 문제에 주어진 테스트
        System.out.println(solution("aabab")); // 3
        System.out.println(solution("dog")); // 8
        System.out.println(solution("aa")); // 0
        System.out.println(solution("baaaaa")); // -1

        // 추가 테스트
        System.out.println(solution("")); // 2
        System.out.println(solution("a")); // 1
        System.out.println(solution("b")); // 4
        System.out.println(solution("aba")); // 2
        System.out.println(solution("abaa")); // 1
        System.out.println(solution("aabaa")); // 0
        System.out.println(solution("aabaaa")); // -1
    }

}