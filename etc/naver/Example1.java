package naver;

public class Example1 {

    static String right(String s, int n) {
        if (s.length() <= n)
            return s;
        return s.substring(s.length() - n);
    }

    static String solution(int a, int b, String result) {
        if (a == 0 && b == 0)
            return result;
        if (a > 0 && right(result, 2).equals("AA") == false) {
            String newResult = solution(a - 1, b, result + "A");
            if (newResult != null) return newResult;
        }
        if (b > 0 && right(result, 2).equals("BB") == false) {
            String newResult = solution(a, b - 1, result + "B");
            if (newResult != null) return newResult;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 3, ""));
    }
}